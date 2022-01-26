//地图容器
var chart = echarts.init(document.getElementById('main'));
//34个省、市、自治区的名字拼音映射数组
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
	console.log(params);
	if(params.componentType == 'series'){
		var html =  
            '<div class="hj">外地车辆：<a href="车辆去向月度汇总.html" target="_top">300</a>辆<br/>'+
			'	  本地车辆：<a href="车辆去向月度汇总.html">300</a>辆</div>          '+
			'	<div class="con">                       '+
			'	  <table width="100%" class="grid">     '+
			'		<tr>                                '+
			'		  <th>序号</th>                       '+
			'		  <th>车牌号</th>                     '+
			'		  <th>行驶状态</th>                     '+
			'		  <th>车辆来源</th>                     '+
			'		</tr>                               '+
			'		<tr>                                  '+
			'		  <td>1</td>                         '+
			'		  <td>冀CUU911</td>                   '+
			'		  <td>停车</td>                      '+
			'		  <td>唐山</td>                   '+
			'		</tr>                            '+
			'		<tr>                                  '+
			'		  <td>2</td>                         '+
			'		  <td>冀CUU911</td>                   '+
			'		  <td>停车</td>                      '+
			'		  <td>唐山</td>                   '+
			'		</tr>                            '+	
			'		<tr>                                  '+
			'		  <td>3</td>                         '+
			'		  <td>冀CUU911</td>                   '+
			'		  <td>停车</td>                      '+
			'		  <td>唐山</td>                   '+
			'		</tr>                            '+
			'		<tr>                                  '+
			'		  <td>4</td>                         '+
			'		  <td>冀CUU911</td>                   '+
			'		  <td>停车</td>                      '+
			'		  <td>唐山</td>                   '+
			'		</tr>                            '+
			'		<tr>                                  '+
			'		  <td>5</td>                         '+
			'		  <td>冀CUU911</td>                   '+
			'		  <td>停车</td>                      '+
			'		  <td>唐山</td>                   '+
			'		</tr>                            '+	
			'		<tr>                                  '+
			'		  <td>1</td>                         '+
			'		  <td>冀CUU911</td>                   '+
			'		  <td>停车</td>                      '+
			'		  <td>唐山</td>                   '+
			'		</tr>                            '+
			'		<tr>                                  '+
			'		  <td>2</td>                         '+
			'		  <td>冀CUU911</td>                   '+
			'		  <td>停车</td>                      '+
			'		  <td>唐山</td>                   '+
			'		</tr>                            '+	
			'		<tr>                                  '+
			'		  <td>3</td>                         '+
			'		  <td>冀CUU911</td>                   '+
			'		  <td>停车</td>                      '+
			'		  <td>唐山</td>                   '+
			'		</tr>                            '+
			'		<tr>                                  '+
			'		  <td>4</td>                         '+
			'		  <td>冀CUU911</td>                   '+
			'		  <td>停车</td>                      '+
			'		  <td>唐山</td>                   '+
			'		</tr>                            '+
			'		<tr>                                  '+
			'		  <td>5</td>                         '+
			'		  <td>冀CUU911</td>                   '+
			'		  <td>停车</td>                      '+
			'		  <td>唐山</td>                   '+
			'		</tr>                            '+	
			'	  </table>                            '+
			'	</div>'                        
            ;

			new $.flavr({title:params.name,animateEntrance:'flip',content:html, buttons:{关闭:{}}});
	}else{
		if(params.name in provinces){
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
			renderMap('中国',mapdata);
		}
	}
});

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
	var scatterData = [];
	
	//根据传过来的map名称加载不同地区的散点，测试环境使用。
	//正式环境请求ajax请求后台具体数据 得到每个地区的具体散点信息填充scatterData
	if(map=="中国"){
		scatterData.push({name: '秦皇岛', value: [119.57,39.95]});
		
	
	}else if(map in provinces){
		if(map=="河北"){
			scatterData.push({name: '秦皇岛', value: [119.57,39.95]});
		}
		
	}else{
		if(map=="秦皇岛市"){
			scatterData.push({name: '秦皇岛', value: [119.57,39.95]});
		}
		
		
	};
	var scatterData0 = [];
	
	//根据传过来的map名称加载不同地区的散点，测试环境使用。
	//正式环境请求ajax请求后台具体数据 得到每个地区的具体散点信息填充scatterData
	if(map=="中国"){

		scatterData0.push({name: '大庆', value: [125.03,46.58]});
	}else if(map in provinces){
	
		if(map=="黑龙江"){
			scatterData0.push({name: '大庆', value: [125.03,46.58]});
		}
		
	}else{
		
		if(map=="大庆市"){
			scatterData0.push({name: '大庆', value: [125.03,46.58]});
		}
		
	};
	
	var scatterData01 = [];
	
	
	if(map=="中国"){

		scatterData01.push({name: '鄂尔多斯', value: [109.781327, 39.608266]});
	}else if(map in provinces){
	
		if(map=="内蒙古"){
			scatterData01.push({name: '鄂尔多斯', value: [109.781327, 39.608266]});
		}
		
	}else{
		
		if(map=="鄂尔多斯市"){
			scatterData01.push({name: '鄂尔多斯', value: [109.781327, 39.608266]});
		}
		
	};
	
	
	
	var scatterData02 = [];
	
	
	if(map=="中国"){

		scatterData02.push({name: '乌鲁木齐', value: [87.68,43.77]});
	}else if(map in provinces){
	
		if(map=="新疆"){
			scatterData02.push({name: '乌鲁木齐', value: [87.68,43.77]});
		}
		
	}else{
		
		if(map=="乌鲁木齐"){
			scatterData02.push({name: '乌鲁木齐', value: [87.68,43.77]});
		}
		
	};
	
	
	option.series = [
		{
		    name: map,
		    type: 'effectScatter',
		    coordinateSystem: 'geo',
		    data: scatterData,
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
		            formatter: function (param) { 
		        		return Math.ceil(Math.random()*50);
                    },
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
		            color: '#FFF500'
		        }
		    }
		},
		{
		    name: map,
		    type: 'effectScatter',
		    coordinateSystem: 'geo',
		    data: scatterData0,
		    hoverAnimation: true,
		  
			 showEffectOn: 'render',
            rippleEffect:{              //涟漪特效相关配置。
							period:2,               //动画的时间。
							scale:4,              //动画中波纹的最大缩放比例。
							brushType:'fill',      //波纹的绘制方式，可选 'stroke' 和 'fill'。
						},
           
		    symbolSize: '15',
		    label: {
		        normal: {
		            formatter: function (param) { 
		        		return Math.ceil(Math.random()*50);
                    },
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
		            color: '#FF7900'
		        }
		    }
		},
		
		{
		    name: map,
		    type: 'effectScatter',
		    coordinateSystem: 'geo',
		    data: scatterData01,
		    hoverAnimation: true,
		  
			 showEffectOn: 'render',
            rippleEffect:{              //涟漪特效相关配置。
							period:2,               //动画的时间。
							scale:5,              //动画中波纹的最大缩放比例。
							brushType:'fill',      //波纹的绘制方式，可选 'stroke' 和 'fill'。
						},
           
		    symbolSize: '15',
		    label: {
		        normal: {
		            formatter: function (param) { 
		        		return Math.ceil(Math.random()*50);
                    },
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
		            color: '#ff0000'
		        }
		    }
		},
		{
		    name: map,
		    type: 'effectScatter',
		    coordinateSystem: 'geo',
		    data: scatterData02,
		    hoverAnimation: true,
		  
			 showEffectOn: 'render',
            rippleEffect:{              //涟漪特效相关配置。
							period:2,               //动画的时间。
							scale:6,              //动画中波纹的最大缩放比例。
							brushType:'fill',      //波纹的绘制方式，可选 'stroke' 和 'fill'。
						},
           
		    symbolSize: '15',
		    label: {
		        normal: {
		            formatter: function (param) { 
		        		return Math.ceil(Math.random()*50);
                    },
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
		            color: '#C10389'
		        }
		    }
		}
		
    ];
    //渲染地图
    chart.setOption(option);
}