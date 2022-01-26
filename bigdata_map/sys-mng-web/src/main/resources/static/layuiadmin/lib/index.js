/**

 @Name：layuiAdmin iframe版主入口
 @Author：贤心
 @Site：http://www.layui.com/admin/
 @License：LPPL
    
 */
layui.extend({
  setter: 'config' //配置模块
  ,admin: 'lib/admin' //核心模块
  ,view: 'lib/view' //视图渲染模块
}).define(['setter', 'admin'], function(exports){
  var setter = layui.setter
  ,element = layui.element
  ,admin = layui.admin
  ,tabsPage = admin.tabsPage
   ,laytpl = layui.laytpl
  ,view = layui.view

  //打开标签页
  ,openTabsPage = function(url, text){
    //遍历页签选项卡
    var matchTo
    ,tabs = $('#LAY_app_tabsheader>li')
    ,path = url.replace(/(^http(s*):)|(\?[\s\S]*$)/g, '');
    
    tabs.each(function(index){
      var li = $(this)
      ,layid = li.attr('lay-id');
      
      if(layid === url){
        matchTo = true;
        tabsPage.index = index;
      }
    });
    
    text = text || '新标签页';
    
    if(setter.pageTabs){
      //如果未在选项卡中匹配到，则追加选项卡
      if(!matchTo){
        $(APP_BODY).append([
          '<div class="layadmin-tabsbody-item layui-show">'
            ,'<iframe src="'+ url +'" frameborder="0" class="layadmin-iframe"></iframe>'
          ,'</div>'
        ].join(''));
        tabsPage.index = tabs.length;
        element.tabAdd(FILTER_TAB_TBAS, {
          title: '<span>'+ text +'</span>'
          ,id: url
          ,attr: path
        });
      }
    } else {
      var iframe = admin.tabsBody(admin.tabsPage.index).find('.layadmin-iframe');
      iframe[0].contentWindow.location.href = url;
    }

    //定位当前tabs
    element.tabChange(FILTER_TAB_TBAS, url);
    admin.tabsBodyChange(tabsPage.index, {
      url: url
      ,text: text
    });
  }
  
  ,APP_BODY = '#LAY_app_body', FILTER_TAB_TBAS = 'layadmin-layout-tabs'
  ,$ = layui.$, $win = $(window);
  
  //初始
  if(admin.screen() < 2) admin.sideFlexible();
  
  //将模块根路径设置为 controller 目录
  layui.config({
    base: setter.base + 'modules/'
  });
  
  //扩展 lib 目录下的其它模块
  layui.each(setter.extend, function(index, item){
    var mods = {};
    mods[item] = '{/}' + setter.base + 'lib/extend/' + item;
    layui.extend(mods);
  });
  
  view().autoRender();
  
  //加载公共模块
  layui.use('common');

    var menuStr = ' {{#  layui.each(d.data, function(index, item){ }}\n' +
        '      <li data-name="{{=  item.id }}" class="layui-nav-item">\n' +
        '      {{#  if(item.children.length !== 0){ }}\n' +
        '        <a href="javascript:;" lay-tips="{{=  item.label }}" lay-direction="2">\n' +
        '          <i class="{{=  item.iconCls }}"></i>\n' +
        '          <cite>{{ item.label }}</cite>\n' +
        '          <span class="layui-nav-more"></span>\n' +
        '        </a>\n' +
        '\n' +
        '       \n' +
        '        <dl class="layui-nav-child">\n' +
        '          {{#  layui.each(item.children, function(index, item1){ }}\n' +
        '\n' +
        '            {{#  if(item1.children.length !== 0){ }}\n' +
        '              <a href="javascript:;" lay-tips="{{=  item1.label }}" lay-direction="2" style="left: 5%">\n' +
        '                <i class="{{=  item.iconCls }}" style="font-size: 12px;" ></i>\n' +
        '                <cite>{{ item1.label }}</cite>\n' +
        '                <span class="layui-nav-more" style="right: 12%;"></span>\n' +
        '              </a>       \n' +
        '              <dl class="layui-nav-child">\n' +
        '                {{#  layui.each(item1.children, function(index, item2){ }}\n' +
        '                <dd data-name="{{=  item2.id }}">\n' +
        '                  <a lay-href="{{= item2.path }}" style="left: 10%;padding-left: 45px">\n' +
        '                    <i class="{{=  item2.iconCls }}" style="font-size: 12px;"></i>\n' +
        '                    <cite> {{ item2.label }}</cite>\n' +
        '                  </a>\n' +
        '                </dd>\n' +
        '                {{#  }); }}\n' +
        '               </dl>\n' +
        '            {{# } else  { }}\n' +
        '            <dd data-name="{{=  item1.id }}">\n' +
        '              <a lay-href="{{= item1.path }}"style="left: 5%">\n' +
        '                <i class="{{=  item1.iconCls }}" style="font-size: 12px;" ></i>\n' +
        '                <cite> {{ item1.label }}</cite>\n' +
        '              </a>\n' +
        '            </dd>\n' +
        '             {{# } }}\n' +
        '          {{#  }); }}\n' +
        '        </dl>\n' +
        '        \n' +
        '\n' +
        '      {{# } else  { }}\n' +
        '          <a href="javascript:;" lay-tips="{{= item.label }}"  lay-href="{{= item.path }}"  lay-direction="2">\n' +
        '            <i class="{{=  item.iconCls }}"></i>\n' +
        '            <cite>{{ item.label }}</cite>\n' +
        '          </a>\n' +
        '      {{# } }}\n' +
        '\n' +
        '      \n' +
        '</li>\n' +
        '{{#  }); }}'+
        '      <span class="layui-nav-bar"></span>';
  /*var menuStr ='{{#  layui.each(d.data, function(index, item){ }}\n' +
      '      <li data-name="{{=  item.id }}" class="layui-nav-item">\n' +
      '      {{#  if(item.children.length !== 0){ }}\n' +
      '        <a href="javascript:;" lay-tips="{{=  item.label }}" lay-direction="2">\n' +
      '          <i class="{{=  item.iconCls }}"></i>\n' +
      '          <cite>{{ item.label }}</cite>\n' +
      '          <span class="layui-nav-more"></span>\n' +
      '        </a>\n' +
      '          {{# } else  { }}\n' +
      '          <a href="javascript:;" lay-tips="{{= item.label }}"  lay-href="{{= item.path }}"  lay-direction="2">\n' +
      '            <i class="{{=  item.iconCls }}"></i>\n' +
      '            <cite>{{ item.label }}</cite>\n' +
      '          </a>\n' +
      '          {{# } }}\n' +
      '          {{#  if(item.children.length !== 0){ }}\n' +
      '        <dl class="layui-nav-child">\n' +
      '          {{#  layui.each(item.children, function(index, item1){ }}\n' +
      '          <dd data-name="{{=  item1.id }}">\n' +
      '            <a lay-href="{{= item1.path }}"><i class="{{=  item1.iconCls }}" style="left: 28px;font-size: 10px;"></i>{{ item1.label }}</a>\n' +
      '          </dd>\n' +
      '          {{#  }); }}\n' +
      '        </dl>\n' +
      '          {{# } }}\n' +
      '          {{#  }); }}\n' +
      '      </li>\n' +
      '      <span class="layui-nav-bar"></span>';*/
  //初始化菜单
    initMenuTree = function() {
        admin.req({
            url: layui.setter.basePath + '/admin/sysUser/loadUserMenueAll.jsn',
            data:{},
            method:"post",
            success:function (data) {
              //根据模板渲染菜单
                laytpl(menuStr).render(data, function(html){
                  $("#LAY-system-side-menu").html(html);
                    //更新渲染
                    element.init();
                });
            },
        });
    }








  //对外输出
  exports('index', {
    openTabsPage: openTabsPage
  });
});
