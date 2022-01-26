//需依赖 video-player.js
var commonLiveService = (function(){
    var service = {};
    /**
     * domid
     * @param elId
     */
    service.init = function(elId){
        window.ruimingVideoPlayer = new VideoPlayer();
        var videoWrap = document.getElementById("video");
        window.ruimingVideoPlayer.init(videoWrap,{
            windowcount:64,
            lang:'Chinese',
            type:'liveview',
            defaultcount:4
        });
    }

    /**
      car={
      //bigdata_beidou_safety_car_info表中的信息
        "carPlateNum":"冀C13387",
        "carPlateColor":"2",
        "sim":"40281816814",
         "deviceType":"200",
        "channelEnable":"1,5,6",
        //BIGDATA_BEIDOU_COMP 表中的信息
        "liveIp":"39.106.199.153",
        "livePort":6031,
        "liveType":"ruiming"
      }
     * @param car
     */
    service.addCarLive =  function(car){
        var channelStr = car.channelEnable;
        channelStr = '[' + channelStr + ']';
        var channel = eval(channelStr);
        var id = car.carPlateNum + '0' + car.carPlateColor + '+0' + car.sim;
        var carinfo;
        if(car.liveType=='ruiming'){
            carinfo = {
                "channel" : channel,
                "id": id,
                "phone" : car.sim,
                "color" : "0" + car.carPlateColor,
                "carlicense" : car.carPlateNum,
                "title" : car.carPlateNum + "监控",
                "name" : car.carPlateNum +"forder",
                "gtip" : car.liveIp,
                "gtport" : car.livePort,
                "devicetype" : 200
            }
            window.ruimingVideoPlayer.open(carinfo);
        }

    }

    return service;
})();