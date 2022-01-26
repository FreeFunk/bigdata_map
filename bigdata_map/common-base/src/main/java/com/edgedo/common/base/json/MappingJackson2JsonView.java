package com.edgedo.common.base.json;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.view.json.AbstractJackson2View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.*;
import java.util.Map.Entry;


public class MappingJackson2JsonView extends AbstractJackson2View {
	public static final String DEFAULT_CONTENT_TYPE = "application/json";
	public static final String DEFAULT_JSONP_CONTENT_TYPE = "application/javascript";
	private String jsonPrefix;
	private Set<String> modelKeys;
	private boolean extractValueFromSingleKeyModel = false;
	private Set<String> jsonpParameterNames = new LinkedHashSet(Arrays.asList(new String[] { "jsonp", "callback" }));

	public MappingJackson2JsonView() {
		super(Jackson2ObjectMapperBuilder.json().build(), "application/json");
	}

	public void setJsonPrefix(String jsonPrefix) {
		this.jsonPrefix = jsonPrefix;
	}

	public void setPrefixJson(boolean prefixJson) {
		this.jsonPrefix = prefixJson ? "{} && " : null;
	}

	public void setModelKey(String modelKey) {
		this.modelKeys = Collections.singleton(modelKey);
	}

	public void setModelKeys(Set<String> modelKeys) {
		this.modelKeys = modelKeys;
	}

	public final Set<String> getModelKeys() {
		return this.modelKeys;
	}

	@Deprecated
	public void setRenderedAttributes(Set<String> renderedAttributes) {
		this.modelKeys = renderedAttributes;
	}

	@Deprecated
	public final Set<String> getRenderedAttributes() {
		return this.modelKeys;
	}

	public void setExtractValueFromSingleKeyModel(boolean extractValueFromSingleKeyModel) {
		this.extractValueFromSingleKeyModel = extractValueFromSingleKeyModel;
	}

	public void setJsonpParameterNames(Set<String> jsonpParameterNames) {
		this.jsonpParameterNames = jsonpParameterNames;
	}

	private String getJsonpParameterValue(HttpServletRequest request) {
		if (this.jsonpParameterNames != null) {
			Iterator arg1 = this.jsonpParameterNames.iterator();

			while (arg1.hasNext()) {
				String name = (String) arg1.next();
				String value = request.getParameter(name);
				if (!StringUtils.isEmpty(value)) {
					return value;
				}
			}
		}

		return null;
	}

	protected Object filterModel(Map<String, Object> model) {
		HashMap result = new HashMap(model.size());
		Set modelKeys = !CollectionUtils.isEmpty(this.modelKeys) ? this.modelKeys : model.keySet();
		Iterator arg3 = model.entrySet().iterator();

		while (arg3.hasNext()) {
			Entry entry = (Entry) arg3.next();
			if (!(entry.getValue() instanceof BindingResult) && modelKeys.contains(entry.getKey())
					&& !((String) entry.getKey()).equals(JsonView.class.getName())) {
				result.put(entry.getKey(), entry.getValue());
			}
		}

		return this.extractValueFromSingleKeyModel && result.size() == 1 ? result.values().iterator().next() : result;
	}


	protected void setResponseContentType(HttpServletRequest request, HttpServletResponse response) {
		if (this.getJsonpParameterValue(request) != null) {
			response.setContentType("application/javascript");
		} else {
			super.setResponseContentType(request, response);
		}

	}
	
	protected void writeContent(OutputStream stream, Object object) throws IOException {
		if(object!=null && object instanceof Map){
			String  str = "limit,start,end,totalCount,totalPage,orderBy,list,success,data,errMsg,errType,code,";
			Map<String,Object> map = (Map<String,Object>)object;
			Iterator<String> it =  map.keySet().iterator();
			while(it.hasNext()){
				String key = it.next();
				if(!str.contains(key+",")){
					it.remove();
					map.remove(key);
				}
			}
		}	
		ObjectMapper objectMapper = this.getObjectMapper();
		JsonGenerator generator = objectMapper.getFactory().createGenerator(stream, this.getEncoding());
		this.writePrefix(generator, object);
		Class serializationView = null;
		Object value = object;
		if (object instanceof MappingJacksonValue) {
			MappingJacksonValue container = (MappingJacksonValue) object;
			value = container.getValue();
			serializationView = container.getSerializationView();
		}

		if (serializationView != null) {
			objectMapper.writerWithView(serializationView).writeValue(generator, value);
		} else {
			objectMapper.writeValue(generator, value);
		}

		this.writeSuffix(generator, object);
		generator.flush();
	}

}