
var basePathUrl = parent.basePathUrl;
//地图容器
var chart = echarts.init(document.getElementById('main'));

var paramsData;
var type;

function updateMapPoint(){
	if(typeof(paramsData) == 'undefined'){
		renderMap('中国',mapdata);
	}else {
		updateMapPointNew(paramsData,type);
	}
}


function updateMapPointNew(params,type) {
	if(typeof (type) =='undefined'){
		renderMap('中国',mapdata);
	}else {
		if(type=='PROVINCE'){
			$.getJSON('static/map/province/'+ provinces[params.name] +'.json', function(data){
				echarts.registerMap(params.name, data);
				var d = [];
				for( var i=0;i<data.features.length;i++ ){
					d.push({
						name:data.features[i].properties.name
					})
				}
				renderMap(params.name,d);
			});
		}else if(type=='CITY'){
			$.getJSON('static/map/city/'+ cityMap[params.name] +'.json', function(data){
				echarts.registerMap(params.name, data);
				var d = [];
				for( var i=0;i<data.features.length;i++ ){
					d.push({
						name:data.features[i].properties.name
					})
				}
				renderMap(params.name,d);
			});
		}else{
			renderMap('中国',mapdata);
		}
	}
}



var provinces = {
	//23个省
	"台湾": "taiwan",
	"河北": "hebei",
	"山西": "shanxi",
	"辽宁": "liaoning",
	"吉林": "jilin",
	"黑龙江": "heilongjiang",
	"江苏": "jiangsu",
	"浙江": "zhejiang",
	"安徽": "anhui",
	"福建": "fujian",
	"江西": "jiangxi",
	"山东": "shandong",
	"河南": "henan",
	"湖北": "hubei",
	"湖南": "hunan",
	"广东": "guangdong",
	"海南": "hainan",
	"四川": "sichuan",
	"贵州": "guizhou",
	"云南": "yunnan",
	"陕西": "shanxi1",
	"甘肃": "gansu",
	"青海": "qinghai",
	//5个自治区
	"新疆": "xinjiang",
	"广西": "guangxi",
	"内蒙古": "neimenggu",
	"宁夏": "ningxia",
	"西藏": "xizang",
	//4个直辖市
	"北京": "beijing",
	"天津": "tianjin",
	"上海": "shanghai",
	"重庆": "chongqing",
	//2个特别行政区
	"香港": "xianggang",
	"澳门": "aomen"
};

//直辖市和特别行政区-只有二级地图，没有三级地图
var special = ["北京","天津","上海","重庆","香港","澳门"];
var mapdata= [];
//绘制全国地图
$.getJSON('static/map/china.json', function(data){
	var d = [];
	for( var i=0;i<data.features.length;i++ ){
		d.push({
			name:data.features[i].properties.name
		})
	}
	mapdata = d;
	//注册地图
	echarts.registerMap('中国', data);
	//绘制地图
	renderMap('中国',d);
});

//地图点击事件
chart.on('click', function (params) {
	var carType  = $("#carType" , parent.document).val();
	console.log(params);
	if(params.componentType == 'series'){
		var d = params.data;
		var p = {}
		if(d.countType =='PROVINCE'){
		 p = {
		 		"queryObj.currentProvinceId":d.id,
			 	"queryObj.carType":carType

			}
		}else if(d.countType =='CITY'){
			p = {
				"queryObj.currentCityId":d.id,
				"queryObj.carType":carType
			}
		}else if(d.countType =='XIANQU'){
			p = {
				"queryObj.currentXianquId":d.id,
				"queryObj.carType":carType
			}
		}
		$.ajax({
			type: "POST",
			url: basePathUrl+"/admin/carInfo/qtlistpage.jsn",
			data: p,
			dataType: "json",
			beforeSend: function (XMLHttpRequest) {
				XMLHttpRequest.setRequestHeader("access-token", parent.getStorage("access_token"));
			},
			success: function(data){
				if(data.code=="0"){
					debugger;
					var html =
						'<div class="hj">'+
						'	  车辆数量：<a href="javaScript:void()">'+data.list.length+'</a>辆</div>          '+
						'	<div class="con">                       '+
						'	  <table width="100%" class="grid">     '+
						'		<tr>                                '+
						'		  <th>序号</th>                       '+
						'		  <th>车牌号</th>                     '+
						'		  <th>所属县区</th>                     '+
						'		  <th>车辆类型</th>                     '+
						'		  <th>运营状态</th>                     '+
						'		</tr>                               ';
					for(var i=0;i<data.list.length;i++){
						html+='		<tr>                                  '+
							'		  <td>'+(i+1)+'</td>                         '+
							"	  <td><a href='javaScript:void(0);' style=\"color: #6bf4f4;\" onclick=gotoYingYunCL('"+data.list[i].carPlateNum+"')>"+data.list[i].carPlateNum+"</a>"+'</td>                   ';
							if(typeof(data.list[i].xianquName) !='undefined' ){
								html += '		  <td>'+data.list[i].xianquName+'</td>                      ';
							}else {
								html += '		  <td>无</td>                      ';
							}
						html += '		  <td>'+data.list[i].carType+'</td>                      ';
						if(data.list[i].operatFlag=='1'){
							html +='		  <td style="color: #23e20c;">'+'运营中'+'</td>                   ';
						}else {
							html +='		  <td style="    color: #f50909;">'+'未运营'+'</td>                   ';
						}
							html +='		</tr>                            ';
					}
					html +='	  </table>                            '+
						'	</div>';
					new $.flavr({title:params.name,animateEntrance:'flip',content:html, buttons:{关闭:{}}});
				}else {
					/*alert("后台异常!");*/
				}
			}
		});
	}else{
		paramsData = params;
		if(params.name in provinces){
			type  = "PROVINCE"
			//如果点击的是34个省、市、自治区，绘制选中地区的二级地图
			$.getJSON('static/map/province/'+ provinces[params.name] +'.json', function(data){
				echarts.registerMap(params.name, data);
				var d = [];
				for( var i=0;i<data.features.length;i++ ){
					d.push({
						name:data.features[i].properties.name
					})
				}
				renderMap(params.name,d);
			});
			//直接使用geo组件没有地图series所以没有seriesName属性
			//直接使用副标题判断点击的地图的上级省份名称params.seriesName
		}else if (option.title.subtext in provinces && special.indexOf(option.title.subtext)<0){
			type = "CITY";
			//显示县级地图
			$.getJSON('static/map/city/'+ cityMap[params.name] +'.json', function(data){
				echarts.registerMap(params.name, data);
				var d = [];
				for( var i=0;i<data.features.length;i++ ){
					d.push({
						name:data.features[i].properties.name
					})
				}
				renderMap(params.name,d);
			});
		}else{
			type = "XIANQU";
			renderMap('中国',mapdata);
		}
	}
});

function gotoYingYunCL(carPlateNum){

	window.parent.location.href = "yingYunCheLiang.html?queryObj.carPlateNum="+carPlateNum;
}

//初始化绘制全国地图配置
var option = {

	title : {
		left: 'center',
		textStyle:{
			color: '#fff',
			fontSize:16,
			fontWeight:'normal',
			fontFamily:"Microsoft YaHei"
		},
		subtextStyle:{
			color:'#fff',
			fontWeight:'normal',
			fontFamily:'Microsoft YaHei',
			fontSize:22
		}
	},
	tooltip: {
		show: false,
		trigger:'item',
		formatter:'{b}'
	},

	animationDuration:1000,
	animationEasing:'cubicOut',
	animationDurationUpdate:1000
};

function renderMap(map,data){
	var carType  = $("#carType" , parent.document).val();
	option.title.subtext = map;
	option.title.show = false;
	option.geo = {
		show: true,
		map: map,
		roam: false,
		zoom: 1.2,
		label: {
			normal: {
				show: true,
				textStyle: {
					color: "#fff",
					fontSize: 12,
					fontFamily: "Microsoft YaHei"
				}
			},
			emphasis: {
				show: true,
				textStyle: {
					color: "#fff",
					fontSize: 12,
					fontFamily: "Microsoft YaHei"
				}
			}
		},

		itemStyle: {
			normal: {
				borderWidth:2,
				borderColor:'#4AEBF3',

				areaColor: {
					type: 'radial',
					x: 0.5,
					y: 0.5,
					r: 0.8,
					colorStops: [{
						offset: 0,
						color: 'rgba(147, 235, 248, 0)' // 0% 处的颜色
					}, {
						offset: 1,
						color: 'rgba(147, 235, 248, .0)' // 100% 处的颜色
					}],
					globalCoord: false // 缺省为 false
				},
				shadowColor: 'rgba(128, 217, 248, .1)',
				shadowOffsetX: -2,
				shadowOffsetY: 2,
				shadowBlur: 10
			},
			emphasis: {
				areaColor: '#2C93B2',
				borderWidth: 2,

			}
		}
	}

	//根据传过来的map名称加载不同地区的散点，测试环境使用。
	//正式环境请求ajax请求后台具体数据 得到每个地区的具体散点信息填充scatterData
	if(map=="中国"){
		$.ajax({
			type: "POST",
			url: basePathUrl+"/admin/mapLocaltionPoint/list.jsn",
			data: {'queryObj.countType':'PROVINCE','queryObj.carType':carType},
			dataType: "json",
			beforeSend: function (XMLHttpRequest) {
				XMLHttpRequest.setRequestHeader("access-token", parent.getStorage("access_token"));
			},
			success: function(data){
				if(data.code=="0"){
					option.series = [];
					for(var j =0;j<data.data.length;j++){
						var d = {
							name: map,
							type: 'effectScatter',
							coordinateSystem: 'geo',
							data: [{	id:data.data[j].provinceId,
								name: data.data[j].provinceName,
								countType:data.data[j].countType,
								value: [data.data[j].longitude,data.data[j].latitude]
							}],
							hoverAnimation: true,

							showEffectOn: 'render',
							rippleEffect:{              //涟漪特效相关配置。
								period:2,               //动画的时间。
								scale:3,              //动画中波纹的最大缩放比例。
								brushType:'fill',      //波纹的绘制方式，可选 'stroke' 和 'fill'。
							},

							symbolSize: '15',
							label: {
								normal: {
									formatter: data.data[j].carNum+'',
									position: 'inside',
									show: true,
									textStyle: {
										color: '#000'
									}
								},
								emphasis: {
									show: true
								}
							},
							itemStyle: {
								normal: {
									color: getColor(data.data[j].carNum),
								}
							}
						};
						option.series.push(d);
					}
					//渲染地图
					chart.setOption(option,true);
				}else {
					/*alert("后台异常!");*/
				}
			}
		});
	}else if(map in provinces){
		$.ajax({
			type: "POST",
			url: basePathUrl+"/admin/mapLocaltionPoint/list.jsn",
			data: {'queryObj.countType':'CITY','queryObj.provinceName':map,'queryObj.carType':carType},
			dataType: "json",
			beforeSend: function (XMLHttpRequest) {
				XMLHttpRequest.setRequestHeader("access-token", parent.getStorage("access_token"));
			},
			success: function(data){
				if(data.code=="0"){
					option.series = [];
					for(var j =0;j<data.data.length;j++){
						option.series.push({
							name: map,
							type: 'effectScatter',
							coordinateSystem: 'geo',
							data: [{	id:data.data[j].cityId,
								name: data.data[j].cityName,
								countType:data.data[j].countType,
								value: [data.data[j].longitude,data.data[j].latitude]
							}],
							hoverAnimation: true,
							showEffectOn: 'render',
							rippleEffect:{              //涟漪特效相关配置。
								period:2,               //动画的时间。
								scale:3,              //动画中波纹的最大缩放比例。
								brushType:'fill',      //波纹的绘制方式，可选 'stroke' 和 'fill'。
							},
							symbolSize: '15',
							label: {
								normal: {
									formatter: data.data[j].carNum+'',
									position: 'inside',
									show: true,
									textStyle: {
										color: '#000'
									}
								},
								emphasis: {
									show: true
								}
							},
							itemStyle: {
								normal: {
									color:getColor(data.data[j].carNum),
								}
							}
						});
					}
					//渲染地图
					chart.setOption(option,true);
				}else {
					/*alert("后台异常!");*/
				}
			}
		});
	}else{
		$.ajax({
			type: "POST",
			url: basePathUrl+"/admin/mapLocaltionPoint/list.jsn",
			data: {'queryObj.countType':'XIANQU','queryObj.cityName':map,'queryObj.carType':carType},
			dataType: "json",
			beforeSend: function (XMLHttpRequest) {
				XMLHttpRequest.setRequestHeader("access-token", parent.getStorage("access_token"));
			},
			success: function(data){
				if(data.code=="0"){
					option.series = [];
					for(var j =0;j<data.data.length;j++){
						var d = {
							name: map,
							type: 'effectScatter',
							coordinateSystem: 'geo',
							data: [{	id:data.data[j].xianquId,
								name: data.data[j].xianquName,
								countType:data.data[j].countType,
								value: [data.data[j].longitude,data.data[j].latitude]
							}],
							hoverAnimation: true,
							showEffectOn: 'render',
							rippleEffect:{              //涟漪特效相关配置。
								period:2,               //动画的时间。
								scale:3,              //动画中波纹的最大缩放比例。
								brushType:'fill',      //波纹的绘制方式，可选 'stroke' 和 'fill'。
							},
							symbolSize: '15',
							label: {
								normal: {
									formatter: data.data[j].carNum+'',
									position: 'inside',
									show: true,
									textStyle: {
										color: '#000'
									}
								},
								emphasis: {
									show: true
								}
							},
							itemStyle: {
								normal: {
									color:getColor(data.data[j].carNum),
								}
							}
						};
						option.series.push(d);
					}
					//渲染地图
					chart.setOption(option,true);
				}else {
					/*alert("后台异常!");*/
				}
			}
		});

	};

	function getColor(s) {
		if(s<=50){
			return '#FFF500';
		}else if(s<=100){
			return '#FF7900';
		}else if(s<=200){
			return '#C10389';
		}else {
			return '#ff0000';
		}
	}
}