function TFDSSummarizer(){var l=window,k=document,t=l.external,ab,v,q,p='',y={},db=[],E=[],o=[],B,D;if(!l.__gwt_stylesLoaded){l.__gwt_stylesLoaded={};}if(!l.__gwt_scriptsLoaded){l.__gwt_scriptsLoaded={};}function u(){try{return t&&(t.gwtOnLoad&&l.location.search.indexOf('gwt.hybrid')== -1);}catch(a){return false;}}
function x(){if(ab&&(v&&q)){var c=k.getElementById('TFDSSummarizer');var b=c.contentWindow;b.__gwt_initHandlers=TFDSSummarizer.__gwt_initHandlers;if(u()){b.__gwt_getProperty=function(a){return r(a);};}TFDSSummarizer=null;b.gwtOnLoad(B,'TFDSSummarizer',p);}}
function s(){var j,h='__gwt_marker_TFDSSummarizer',i;k.write('<script id="'+h+'"><\/script>');i=k.getElementById(h);j=i&&i.previousSibling;while(j&&j.tagName!='SCRIPT'){j=j.previousSibling;}function d(b){var a=b.lastIndexOf('/');return a>=0?b.substring(0,a+1):'';}
;if(j&&j.src){p=d(j.src);}if(p==''){var c=k.getElementsByTagName('base');if(c.length>0){p=c[c.length-1].href;}else{var g=k.location;var e=g.href;p=d(e.substr(0,e.length-g.hash.length));}}else if(p.match(/^\w+:\/\//)){}else{var f=k.createElement('img');f.src=p+'clear.cache.gif';p=d(f.src);}if(i){i.parentNode.removeChild(i);}}
function C(){var f=document.getElementsByTagName('meta');for(var d=0,g=f.length;d<g;++d){var e=f[d],h=e.getAttribute('name'),b;if(h){if(h=='gwt:property'){b=e.getAttribute('content');if(b){var i,c=b.indexOf('=');if(c>=0){h=b.substring(0,c);i=b.substring(c+1);}else{h=b;i='';}y[h]=i;}}else if(h=='gwt:onPropertyErrorFn'){b=e.getAttribute('content');if(b){try{D=eval(b);}catch(a){alert('Bad handler "'+b+'" for "gwt:onPropertyErrorFn"');}}}else if(h=='gwt:onLoadErrorFn'){b=e.getAttribute('content');if(b){try{B=eval(b);}catch(a){alert('Bad handler "'+b+'" for "gwt:onLoadErrorFn"');}}}}}}
function n(a,b){return b in db[a];}
function m(a){var b=y[a];return b==null?null:b;}
function cb(d,e){var a=o;for(var b=0,c=d.length-1;b<c;++b){a=a[d[b]]||(a[d[b]]=[]);}a[d[c]]=e;}
function r(d){var e=E[d](),b=db[d];if(e in b){return e;}var a=[];for(var c in b){a[b[c]]=c;}if(D){D(d,a,e);}throw null;}
E['user.agent']=function(){var d=navigator.userAgent.toLowerCase();var b=function(a){return parseInt(a[1])*1000+parseInt(a[2]);};if(d.indexOf('opera')!= -1){return 'opera';}else if(d.indexOf('webkit')!= -1){return 'safari';}else if(d.indexOf('msie')!= -1){var c=/msie ([0-9]+)\.([0-9]+)/.exec(d);if(c&&c.length==3){if(b(c)>=6000){return 'ie6';}}}else if(d.indexOf('gecko')!= -1){var c=/rv:([0-9]+)\.([0-9]+)/.exec(d);if(c&&c.length==3){if(b(c)>=1008)return 'gecko1_8';}return 'gecko';}return 'unknown';};db['user.agent']={'gecko':0,'gecko1_8':1,'ie6':2,'opera':3,'safari':4};TFDSSummarizer.onInjectionDone=function(){ab=true;x();};TFDSSummarizer.onScriptLoad=function(){v=true;x();};s();C();var bb;if(u()){bb='hosted.html?TFDSSummarizer';}else{try{cb(['ie6'],'4F9BEFF6B564E37EDA8E874DCBD9E188');cb(['gecko1_8'],'51824373857BF8604B1934AAA0F8C5D9');cb(['gecko'],'7E586BB6FC857FD825E655C5924CDE77');cb(['safari'],'CC8A4520F7B00F088088160FE357B1F3');cb(['opera'],'FCA349760601644AB5D4F7BE77E8EDD8');bb=o[r('user.agent')];}catch(a){return;}bb+='.cache.html';}var A;function z(){if(!q){q=true;x();if(k.removeEventListener){k.removeEventListener('DOMContentLoaded',z,false);}if(A){clearInterval(A);}}}
var F;function w(){if(!F&&k.body){F=true;var a=k.createElement('iframe');a.src="javascript:''";a.id='TFDSSummarizer';a.style.cssText='position:absolute;width:0;height:0;border:none';k.body.appendChild(a);a.src=p+bb;}}
if(k.addEventListener){k.addEventListener('DOMContentLoaded',function(){w();z();},false);}var A=setInterval(function(){w();if(/loaded|complete/.test(k.readyState)){z();}},50);k.write("<script>TFDSSummarizer.onInjectionDone('TFDSSummarizer')<\/script>");}
TFDSSummarizer.__gwt_initHandlers=function(i,e,j){var d=window,g=d.onresize,f=d.onbeforeunload,h=d.onunload;d.onresize=function(a){try{i();}finally{g&&g(a);}};d.onbeforeunload=function(a){var c,b;try{c=e();}finally{b=f&&f(a);}if(c!=null){return c;}if(b!=null){return b;}};d.onunload=function(a){try{j();}finally{h&&h(a);}};};TFDSSummarizer();