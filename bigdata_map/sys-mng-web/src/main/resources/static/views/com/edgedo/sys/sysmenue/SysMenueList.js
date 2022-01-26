    layui.config({
        base: '../../../../../layuiadmin/' //静态资源所在路径
    }).extend({
        index:'lib/index',
        common:'common'
    }).use(['index','table', 'form','common','tree'], function(exports){
        //获取用户信息
        layui.admin.checkUserLogin();

        var $ = layui.$
            ,table = layui.table
            ,tree = layui.tree
            ,common = layui.common
            ,admin = layui.admin
            ,form = layui.form;

        //查询
        form.on('submit(SysMenue-search)', function(obj){
            debugger;
            var field = obj.field;
            //执行重载
            table.reload('SysMenue-list', {
                where: field
            });
        });

       /* //重置查询
        form.on('submit(SysMenue-reset)', function(){
            var field = '';
            $("#searchMenueName").val('');
            layui.form.render();
            //执行重载
            table.reload('SysMenue-list', {
                where: field
            });
        });*/


        /**
         * 初始化菜单树
         * */
        initMenuTree = function() {
            admin.req({
                url:'/admin/sysMenue/loadTree.jsn',
                data:{'parentId':'ROOT'},
                method:"post",
                success:function (data) {
                    renderTree('#menuTree', data.data);
                },
            });
        }
        initMenuTree();

        var shuzhixuanze = 'undefined';

        /**
         * 绘制树
         * @param id dom id
         * @param nodes 树节点数据
         * */
        renderTree =function (id, nodes) {
            //绘制前先清空
            $(id).empty();
            debugger;

            //绘制
            tree({
                elem: id
                , nodes: nodes
                , click: function (node) {//显示组织机构数据
                    debugger;
                    shuzhixuanze = node.id;
                    table.reload('SysMenue-list', {
                        where: {
                            'queryObj.parentId':node.id
                        }
                    });
                }
            });
        }

        /*
        * 定义表格
        * */
        defineTable = function () {
            var headers = layui.admin.getTokenHeader();
            table.render({
                elem: '#SysMenue-list' //指定原始表格的选择器（id选择器）
                ,url: layui.setter.basePath + '/admin/sysMenue/listpage.jsn' //模拟接口
                ,headers:headers
                ,parseData: function(res){ //res 即为原始返回的数据
                    return {
                        "code": res.success, //解析接口状态
                        "msg": res.errMsg, //解析提示文本
                        "count": res.totalCount, //解析数据长度
                        "data": res.list //解析数据列表
                    };
                }
                ,response: {
                    statusCode: true //规定成功的状态码，默认：0
                }
                ,cols: [[
                    {type: 'checkbox', fixed: 'left'}
                        ,{field: 'id',align: 'center', width: '14.2%', title: 'id',sort: true,hide:true}
                        ,{field: 'text',align: 'center', width: '15%', title: '菜单名称',sort: true}
                        ,{field: 'path',align: 'center', width: '40%', title: 'path',sort: true}
                        ,{field: 'parentId',align: 'center', width: '14.2%', title: 'parentId',sort: true,hide:true}
                        ,{field: 'type',align: 'center', width: '13.5%', title: '菜单类型',sort: true,hide:true}
                        ,{field: 'isLeaf',align: 'center', width: '14.2%', title: '是否是叶子节点',sort: true,hide:true}
                        ,{field: 'sortNum',align: 'center', width: '11%', title: '排序号',sort: true}
                        ,{field: 'dataState',align: 'center', width: '14.2%', title: 'dataState',sort: true,hide:true}
                        ,{field: 'iconCls',align: 'center', width: '14.2%', title: 'iconCls',sort: true,hide:true}
                        ,{field: 'openType',align: 'center', width: '9%', title: '状态',sort: true,
                            templet: function(d){
                                if(d.openType=='1'){
                                    return '启用';
                                }else if (d.openType=='0'){
                                    return '停用';
                                }else{
                                    return 'error';
                                }
                            }
                        }
                        /*,{field: 'createTime',align: 'center', width: '25.5%', title: '创建时间',templet: '<div>{{ layui.laytpl.toDateString(d.createTime,"yyyy-MM-dd HH:mm:ss") }}</div>',sort: true}*/
                    ,{title: '操作', minWidth: '', align: 'center', fixed: 'right', toolbar: '#table-SysMenue-list'}
                ]]
                ,autoSort: false
                ,page: true
                ,limit: 10
                ,limits: [10, 20, 30,40]
                ,text: {
                    none: '暂无相关数据'
                }
            });

            //为toolbar添加事件响应
            table.on('tool(SysMenue-list)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
                /*var data = obj.data;*///获得当前行数据
                //区分事件
                switch(obj.event){
                    case 'del':
                        deleteVo(obj);
                        break;
                    case 'edit':
                        editVo(obj);
                        break;
                };
            });

            //监听排序事件
            table.on('sort(SysMenue-list)', function(obj){ //注：sort是工具条事件名，LAY-app-province-list是table原始容器的属性 lay-filter="对应的值"
                var sort = obj.field;
                //默认排序
                switch(obj.field){
                    case 'id':
                        sort ="ID";
                        break;
                    case 'text':
                        sort ="TEXT";
                        break;
                    case 'path':
                        sort ="PATH";
                        break;
                    case 'parentId':
                        sort ="PARENT_ID";
                        break;
                    case 'type':
                        sort ="TYPE";
                        break;
                    case 'isLeaf':
                        sort ="IS_LEAF";
                        break;
                    case 'sortNum':
                        sort ="SORT_NUM";
                        break;
                    case 'dataState':
                        sort ="DATA_STATE";
                        break;
                    case 'iconCls':
                        sort ="ICON_CLS";
                        break;
                    case 'openType':
                        sort ="OPEN_TYPE";
                        break;
                    case 'createTime':
                        sort ="CREATE_TIME";
                        break;
                };
                if(obj.type==null){
                    return;
                }
                //有些时候，你可能需要根据当前排序的字段，重新向服务端发送请求，从而实现服务端排序，如：
                table.reload('SysMenue-list', {
                    initSort: obj//记录初始排序，如果不设的话，将无法标记表头的排序状态。
                    ,where: { //请求参数（注意：这里面的参数可任意定义，并非下面固定的格式）
                        orderBy: sort+" "+obj.type //排序字段
                    }
                });
            });
        }
        defineTable();

        //删除
        deleteVo = function (obj) {
            layer.confirm('确定删除此记录吗？', function(index){
                admin.req({
                    url:'/admin/sysMenue/deleteByIds.jsn',
                    data:{'ids':obj.data.id},
                    method:"post",
                    success:function (data) {
                        table.reload('SysMenue-list',
                            {page:
                                { curr: common.deleteJumpPage(obj) // 执行页面跳转方法
                                }
                            }
                        );
                        layer.close(index);
                        layer.msg('删除成功', {
                            icon: 1
                        });
                    },
                });
            });
        }
        //编辑
        editVo = function (obj) {
            layer.open({
                type: 2
                ,title: '编辑'
                ,content: 'SysMenueEdit.html'
                ,maxmin: true
                ,area: ['550px', '550px']
                ,btn: ['确定', '取消']
                ,success: function(layero, index){
                    var s = layero.find('iframe');
                    $("id",s[0].contentWindow.document).val(obj.data.id);
                    //给iframe元素赋值
                    var othis = layero.find('iframe').contents().find("#SysMenue-form").click();

                    othis.find('input[name="id"]').val(obj.data.id);
                    othis.find('input[name="text"]').val(obj.data.text);
                    othis.find('input[name="path"]').val(obj.data.path);
                    othis.find('input[name="parentId"]').val(obj.data.parentId);
                    othis.find('input[name="type"]').val(obj.data.type);
                    othis.find('input[name="isLeaf"]').val(obj.data.isLeaf);
                    othis.find('input[name="sortNum"]').val(obj.data.sortNum);
                    othis.find('input[name="dataState"]').val(obj.data.dataState);
                    othis.find('input[name="iconCls"]').val(obj.data.iconCls);
                    othis.find('input[name="openType"]').val(obj.data.openType);
                    if(obj.data.openType=="1"){
                        othis.find('input[name="openType"]').attr("checked", true);
                    }
                    othis.find('input[name="createTime"]').val(obj.data.createTime);
                }
                ,yes: function(index, layero){
                    var submit = layero.find('iframe').contents().find("#SysMenue-form-edit");
                    submit.trigger('click');
                }
            });
        }

        //点击事件
        var active = {
            //批量删除
            batchdel: function(){
                var checkStatus = table.checkStatus('SysMenue-list')
                    ,checkData = checkStatus.data; //得到选中的数据

                if(checkData.length === 0){
                    return layer.msg('请选择数据');
                }

                layer.confirm('确定删除吗？', function(index) {
                    var ids = "" ;
                    for(var i = 0;i<checkData.length;i++){
                        if(ids==""){
                            ids= checkData[i].id;
                        }else {
                            ids = ids+","+checkData[i].id;
                        }
                    }
                    admin.req({
                        url:'/admin/sysMenue/deleteByIds.jsn',
                        data:{'ids':ids},
                        method:"post",
                        success:function (data) {
                            table.reload('SysMenue-list',
                                {page:
                                    { curr: common.deleteDulJumpPage(checkStatus) // 执行页面跳转方法
                                    }
                                }
                            );
                            layer.msg('删除成功', {
                                icon: 1
                            });
                        },
                    });
                });
            }
            //添加
            ,add: function(){
                layer.open({
                    type: 2
                    ,title: '添加'
                    ,content: 'SysMenueAdd.html'
                    ,maxmin: true
                    ,area: ['550px', '550px']
                    ,btn: ['确定', '取消']
                    ,yes: function(index, layero){
                        //点击确认触发 iframe 内容中的按钮提交
                        var submit = layero.find('iframe').contents().find("#SysMenue-form-submit");
                        submit.click();
                    }
                });
            }
        }
        //绑定点击事件
        $('.layui-btn.layuiadmin-btn-comm').on('click', function(){
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });
    });
