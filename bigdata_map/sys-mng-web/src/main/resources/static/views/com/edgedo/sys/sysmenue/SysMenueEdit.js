layui.config({
    base: '../../../../../layuiadmin/' //静态资源所在路径
}).extend({
    index: 'lib/index', //主入口模块
    $tool:'tool'
}).use(['index', 'form','$tool','laydate'], function(){

    var $ = layui.$
        ,$tool = layui.$tool
        ,laydate = layui.laydate
        ,admin = layui.admin
        ,form = layui.form;

    /*var queryArgs = $tool.getQueryParam();//获取查询参数
    var id = queryArgs['id'];*/
    //监听修改保存
    form.on('submit(SysMenue-form-edit)', function(data){
        debugger
        var field = data.field; //获取提交的字段
        field['openType']=$("#openType").val();
        var index = parent.layer.getFrameIndex(window.name);//先得到当前iframe层的索引
        admin.req({
            url:'/admin/sysMenue/saveOrUpdate.jsn',
            data:field,
            method:"post",
            success:function (data) {
                parent.layui.table.reload('SysMenue-list'); //重载表格
                parent.layer.close(index); //再执行关闭
                parent.layer.msg('修改成功', {
                    icon: 1
                });
            }
        });
    });

    form.on('switch(openType)', function(data){
        debugger;
        var oldData = data.elem.checked;
        if(!oldData){
            $("#openType").val("0");
        }else if(oldData){
            $("#openType").val("1");
        }
    })

    laydate.render({
        elem: '#createTime', //指定元素
        type:'datetime'
    });
})