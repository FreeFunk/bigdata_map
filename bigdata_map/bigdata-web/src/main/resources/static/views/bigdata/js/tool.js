
//路径
//var basePathUrl = "http://qhdbd.qhd12328.com";
var basePathUrl = "http://localhost:8097";


/**
 *@Author:ZhaoSiDa
 *@Description:通用的ajax请求方法
 *@DateTime 2020/4/14 13:50
 */
function adminReq(url,params,success) {
    $.ajax({
        type: "POST",
        url: url,
        data: params,
        dataType: "json",
        beforeSend: function (XMLHttpRequest) {
            XMLHttpRequest.setRequestHeader("access-token", getStorage("access_token"));
        },
        success: function(data){
            if(data.success){
                success(data);
            }else {
                if(data.code==1001){
                    location.href = '../../login.html';
                }else {
                    layer.msg('后台异常', {
                        icon: 5
                    });
                }
            }
        }
    });
}
/**
 * 获取查询字符串参数
 * */
function getQueryParam() {
    var args = new Object();
    var query = location.search.substring(1);//获取查询串
    var pairs = query.split("&");//在逗号处断开
    for (var i = 0; i < pairs.length; i++) {
        var pos = pairs[i].indexOf('=');//查找name=value
        if (pos == -1) continue;//如果没有找到就跳过
        var argname = pairs[i].substring(0, pos);//提取name
        var value = pairs[i].substring(pos + 1);//提取value
        args[argname] = value;//存为属性
    }
    return args;
}

/**
 * 日期格式化
 * */
function dateFormat(fmt,date){
    var o = {
        "M+": date.getMonth() + 1, //月份
        "d+": date.getDate(), //日
        "h+": date.getHours(), //小时
        "m+": date.getMinutes(), //分
        "s+": date.getSeconds(), //秒
        "q+": Math.floor((date.getMonth() + 3) / 3), //季度
        "S": date.getMilliseconds() //毫秒
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (date.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}


function getStorage(name) {
    return JSON.parse(localStorage.getItem(name))
}

function setStorage(name, val) {
    localStorage.setItem(name, JSON.stringify(val))
}

function addStorage(name, addVal) {
    var oldVal = Storage.get(name)
    var newVal = oldVal.concat(addVal)
    Storage.set(name, newVal)
}

//生成从minNum到maxNum的随机数
function randomNum(minNum,maxNum){
    switch(arguments.length){
        case 1:
            return parseInt(Math.random()*minNum+1,10);
            break;
        case 2:
            return parseInt(Math.random()*(maxNum-minNum+1)+minNum,10);
            break;
        default:
            return 0;
            break;
    }
}