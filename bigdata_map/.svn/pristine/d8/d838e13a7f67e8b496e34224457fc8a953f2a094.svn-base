layui.config({
    base: '../../../../../layuiadmin/' //静态资源所在路径
}).extend({
    index: 'lib/index' //主入口模块
}).use(['index', 'form','laydate'], function(){
    var $ = layui.$
        ,laydate = layui.laydate
        ,admin = layui.admin
        ,form = layui.form;

    //监听提交
    form.on('submit(SysMenue-form-submit)', function(data){
        debugger;
        var field = data.field; //获取提交的字段
        var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
        //提交 Ajax 成功后，关闭当前弹层并重载表格
        admin.req({
            url:'/admin/sysMenue/saveOrUpdate.jsn',
            data:field,
            method:"post",
            success:function (data) {
                parent.layui.table.reload('SysMenue-list'); //重载表格
                parent.layer.close(index); //再执行关闭
                parent.layer.msg('添加成功', {
                    icon: 1
                });
            },
        });

    });
    laydate.render({
        elem: '#createTime', //指定元素
        type:'datetime'
    });
})