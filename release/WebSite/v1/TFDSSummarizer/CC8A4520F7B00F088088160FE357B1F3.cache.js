(function(){var $wnd = window;var $doc = $wnd.document;var $moduleName, $moduleBase;var _,gC='client.',hC='client.service.',iC='com.google.gwt.core.client.',jC='com.google.gwt.lang.',kC='com.google.gwt.user.client.',lC='com.google.gwt.user.client.impl.',mC='com.google.gwt.user.client.rpc.',nC='com.google.gwt.user.client.rpc.core.java.lang.',oC='com.google.gwt.user.client.rpc.core.java.util.',pC='com.google.gwt.user.client.rpc.impl.',qC='com.google.gwt.user.client.ui.',rC='com.google.gwt.user.client.ui.impl.',sC='java.lang.',tC='java.util.';function fC(){}
function wv(a){return this===a;}
function xv(){return Aw(this);}
function uv(){}
_=uv.prototype={};_.eQ=wv;_.hC=xv;_.tN=sC+'Object';_.tI=1;function s(){}
_=s.prototype=new uv();_.tN=gC+'Sentence';_.tI=3;_.a=0.0;_.b=0;_.c=0;_.d='';function w(b,a){C(a,b.qb());D(a,b.rb());E(a,b.rb());F(a,b.tb());}
function x(a){return a.a;}
function y(a){return a.b;}
function z(a){return a.c;}
function A(a){return a.d;}
function B(b,a){b.Cb(x(a));b.Db(y(a));b.Db(z(a));b.Fb(A(a));}
function C(a,b){a.a=b;}
function D(a,b){a.b=b;}
function E(a,b){a.c=b;}
function F(a,b){a.d=b;}
function vb(r){var a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q;c=xp(new vp(),'Input text to be summarized:');g=nr(new mr());pr(g,80);qr(g,25);a=bn(new Bm(),'Summarize');o=xp(new vp(),'Summary Size (% of original):');p=dq(new Bp());for(b=1;b<=100;b++)fq(p,Eu(b));oq(p,false);pq(p,1);nq(p,9,true);d=bp(new Fo());cp(d,a);cp(d,o);cp(d,p);kn(d,o,(to(),vo));kn(d,p,(to(),vo));fs(d,'95%');e=ns(new ls());os(e,c);os(e,g);os(e,d);j=xp(new vp(),'System-generated Summary:');l=nr(new mr());pr(l,80);qr(l,25);xr(l,true);n=jo(new io());k=ns(new ls());os(k,j);os(k,l);os(k,n);f=ko(new io(),'<br><br><br>This summarizer implements the frequency distribution summarization algorithm (using terms rather than concepts) described in these papers:<br><br>Lawrence H. Reeve, Hyoil Han, Saya V. Nagori, Jonathan C. Yang, Tamara A. Schwimmer, and Ari D. Brooks (2006).<br><EM><A href="http://cluster.cis.drexel.edu:8080/biotus/pubs/2006CIKM.pdf">Concept Frequency Distribution in Biomedical Text Summarization<\/A>.<\/EM><br><A href="http://sa1.sice.umkc.edu/cikm2006/"> <FONT face="Times New Roman">Proceedings of the 15th Conference on Information and Knowledge Management<\/FONT><\/A><FONT face="Times New Roman"><\/FONT><A href="http://www.cs.iupui.edu/%7Ebioin/"><\/A>.<br><br>Lawrence H. Reeve and Hyoil Han (2007).<br><EM><a href="http://cluster.cis.drexel.edu:8080/biotus/pubs/2007DUC.pdf">A Term Frequency Distribution Approach for the DUC-2007 Update Task.<\/a><\/EM><br>Proceedings of the 2007 Document Understanding Conference Workshop (DUC 2007)<br><br>');m=bp(new Fo());cp(m,f);h=bp(new Fo());cp(h,e);cp(h,k);Eh(r);xm(cr(),h);xm(cr(),m);r.b=Eb(new yb());q=r.b;i=xc()+'summarizerservice';bc(q,i);r.a=cb(new bb(),r,l,n,a);zg(new gb());ei(),di();tr(g,new jb());ur(g,nb(new mb(),r,l));a.k(rb(new qb(),r,a,l,n,g,p));}
function wb(b,a){}
function ab(){}
_=ab.prototype=new uv();_.pb=wb;_.tN=gC+'TFDSSummarizer';_.tI=4;_.a=null;_.b=null;function cb(b,a,d,e,c){b.b=d;b.c=e;b.a=c;return b;}
function eb(b,a){mo(b.c,'Server Response:\n\n'+a.a);eo(b.a,true);}
function fb(g,c){var a,b,d,e,f;f=Bd(c,2);b=Ev(new Dv());for(a=0;a<f.Bb();a++){d=Bd(f.D(a),3);if(d.c==0){e=d.d;if(e!==null&&lw(e)!=0){aw(b,d.d);aw(b,'\n\n');}}else{aw(b,'['+d.c+']: '+d.d);aw(b,'\n\n');}}yr(g.b,ew(b));zp(g.c,'');eo(g.a,true);}
function bb(){}
_=bb.prototype=new uv();_.tN=gC+'TFDSSummarizer$1';_.tI=0;function ib(){ei(),di();}
function gb(){}
_=gb.prototype=new uv();_.w=ib;_.tN=gC+'TFDSSummarizer$2';_.tI=5;function lb(a){}
function jb(){}
_=jb.prototype=new uv();_.fb=lb;_.tN=gC+'TFDSSummarizer$3';_.tI=6;function jp(c,a,b){}
function kp(c,a,b){}
function lp(c,a,b){}
function hp(){}
_=hp.prototype=new uv();_.ib=jp;_.jb=kp;_.kb=lp;_.tN=qC+'KeyboardListenerAdapter';_.tI=7;function nb(b,a,c){b.a=c;return b;}
function pb(d,a,b){var c;c=wr(this.a);if(c!==null&&lw(c)>0)yr(this.a,'');}
function mb(){}
_=mb.prototype=new hp();_.jb=pb;_.tN=gC+'TFDSSummarizer$4';_.tI=8;function rb(b,a,c,e,f,d,g){b.a=a;b.b=c;b.d=e;b.e=f;b.c=d;b.f=g;return b;}
function tb(a){eo(this.b,false);yr(this.d,'');mo(this.e,'<b><i>Please wait...summarizing the source text.<\/i><\/b>');cc(this.a.b,wr(this.c),Fu(kq(this.f,jq(this.f))),this.a.a);}
function qb(){}
_=qb.prototype=new uv();_.gb=tb;_.tN=gC+'TFDSSummarizer$5';_.tI=9;function ac(){ac=fC;dc=fc(new ec());}
function Eb(a){ac();return a;}
function Fb(d,b,c,a){if(d.a===null)throw hk(new gk());gm(b);jl(b,'client.service.ISummarizerService');jl(b,'summarizeTFDS');hl(b,2);jl(b,'java.lang.String');jl(b,'java.lang.Integer');jl(b,c);il(b,a);}
function bc(b,a){b.a=a;}
function cc(j,i,f,c){var a,d,e,g,h;g=tl(new sl(),dc);h=cm(new am(),dc,xc(),'AF8D9E63B5457AB80016BBD0E4B3C585');try{Fb(j,h,i,f);}catch(a){a=fe(a);if(Cd(a,4)){d=a;eb(c,d);return;}else throw a;}e=Ab(new zb(),j,g,c);if(!gh(j.a,jm(h),e))eb(c,Ej(new Dj(),'Unable to initiate the asynchronous service invocation -- check the network connection'));}
function yb(){}
_=yb.prototype=new uv();_.tN=hC+'ISummarizerService_Proxy';_.tI=0;_.a=null;var dc;function Ab(b,a,d,c){b.b=d;b.a=c;return b;}
function Cb(g,e){var a,c,d,f;f=null;c=null;try{if(mw(e,'//OK')){wl(g.b,nw(e,4));f=cl(g.b);}else if(mw(e,'//EX')){wl(g.b,nw(e,4));c=Bd(cl(g.b),5);}else{c=Ej(new Dj(),e);}}catch(a){a=fe(a);if(Cd(a,4)){a;c=xj(new wj());}else if(Cd(a,5)){d=a;c=d;}else throw a;}if(c===null)fb(g.a,f);else eb(g.a,c);}
function Db(a){var b;b=zc;Cb(this,a);}
function zb(){}
_=zb.prototype=new uv();_.hb=Db;_.tN=hC+'ISummarizerService_Proxy$1';_.tI=0;function gc(){gc=fC;rc=lc();tc=mc();}
function fc(a){gc();return a;}
function hc(d,c,a,e){var b=rc[e];if(!b){sc(e);}b[1](c,a);}
function ic(b,c){var a=tc[c];return a==null?c:a;}
function jc(c,b,d){var a=rc[d];if(!a){sc(d);}return a[0](b);}
function kc(d,c,a,e){var b=rc[e];if(!b){sc(e);}b[2](c,a);}
function lc(){gc();return {'client.Sentence/1365443775':[function(a){return nc(a);},function(a,b){w(a,b);},function(a,b){B(a,b);}],'com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException/3936916533':[function(a){return oc(a);},function(a,b){Bj(a,b);},function(a,b){Cj(a,b);}],'java.lang.Integer/3438268394':[function(a){return nk(a);},function(a,b){mk(a,b);},function(a,b){ok(a,b);}],'java.lang.String/2004016611':[function(a){return sk(a);},function(a,b){rk(a,b);},function(a,b){tk(a,b);}],'java.util.ArrayList/3821976829':[function(a){return pc(a);},function(a,b){wk(a,b);},function(a,b){xk(a,b);}],'java.util.Vector/3125574444':[function(a){return qc(a);},function(a,b){Ak(a,b);},function(a,b){Bk(a,b);}]};}
function mc(){gc();return {'client.Sentence':'1365443775','com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException':'3936916533','java.lang.Integer':'3438268394','java.lang.String':'2004016611','java.util.ArrayList':'3821976829','java.util.Vector':'3125574444'};}
function nc(a){gc();return new s();}
function oc(a){gc();return xj(new wj());}
function pc(a){gc();return gz(new ez());}
function qc(a){gc();return AB(new zB());}
function sc(a){gc();throw ck(new bk(),a);}
function ec(){}
_=ec.prototype=new uv();_.tN=hC+'ISummarizerService_TypeSerializer';_.tI=0;var rc,tc;function xc(){return Ec();}
function yc(a){return a==null?null:a.tN;}
var zc=null;function Cc(a){return a==null?0:a.$H?a.$H:(a.$H=Fc());}
function Dc(a){return a==null?0:a.$H?a.$H:(a.$H=Fc());}
function Ec(){return $moduleBase;}
function Fc(){return ++ad;}
var ad=0;function Cw(b,a){b.a=a;return b;}
function Dw(c,b,a){c.a=b;return c;}
function Bw(){}
_=Bw.prototype=new uv();_.tN=sC+'Throwable';_.tI=10;_.a=null;function lu(b,a){Cw(b,a);return b;}
function mu(c,b,a){Dw(c,b,a);return c;}
function ku(){}
_=ku.prototype=new Bw();_.tN=sC+'Exception';_.tI=11;function zv(b,a){lu(b,a);return b;}
function Av(c,b,a){mu(c,b,a);return c;}
function yv(){}
_=yv.prototype=new ku();_.tN=sC+'RuntimeException';_.tI=12;function cd(c,b,a){zv(c,'JavaScript '+b+' exception: '+a);return c;}
function bd(){}
_=bd.prototype=new yv();_.tN=iC+'JavaScriptException';_.tI=13;function gd(b,a){if(!Cd(a,6)){return false;}return ld(b,Bd(a,6));}
function hd(a){return Cc(a);}
function id(){return [];}
function jd(){return function(){};}
function kd(){return {};}
function md(a){return gd(this,a);}
function ld(a,b){return a===b;}
function nd(){return hd(this);}
function ed(){}
_=ed.prototype=new uv();_.eQ=md;_.hC=nd;_.tN=iC+'JavaScriptObject';_.tI=14;function pd(c,a,d,b,e){c.a=a;c.b=b;c.tN=e;c.tI=d;return c;}
function rd(a,b,c){return a[b]=c;}
function sd(b,a){return b[a];}
function td(a){return a.length;}
function vd(e,d,c,b,a){return ud(e,d,c,b,0,td(b),a);}
function ud(j,i,g,c,e,a,b){var d,f,h;if((f=sd(c,e))<0){throw new ev();}h=pd(new od(),f,sd(i,e),sd(g,e),j);++e;if(e<a){j=nw(j,1);for(d=0;d<f;++d){rd(h,d,ud(j,i,g,c,e,a,b));}}else{for(d=0;d<f;++d){rd(h,d,b);}}return h;}
function wd(a,b,c){if(c!==null&&a.b!=0&& !Cd(c,a.b)){throw new au();}return rd(a,b,c);}
function od(){}
_=od.prototype=new uv();_.tN=jC+'Array';_.tI=0;function zd(b,a){return !(!(b&&be[b][a]));}
function Ad(a){return String.fromCharCode(a);}
function Bd(b,a){if(b!=null)zd(b.tI,a)||ae();return b;}
function Cd(b,a){return b!=null&&zd(b.tI,a);}
function Dd(a){return a&65535;}
function Ed(a){return ~(~a);}
function ae(){throw new gu();}
function Fd(a){if(a!==null){throw new gu();}return a;}
function ce(b,d){_=d.prototype;if(b&& !(b.tI>=_.tI)){var c=b.toString;for(var a in _){b[a]=_[a];}b.toString=c;}return b;}
var be;function fe(a){if(Cd(a,5)){return a;}return cd(new bd(),he(a),ge(a));}
function ge(a){return a.message;}
function he(a){return a.name;}
function je(b,a){return b;}
function ie(){}
_=ie.prototype=new yv();_.tN=kC+'CommandCanceledException';_.tI=15;function af(a){a.a=ne(new me(),a);a.b=gz(new ez());a.d=re(new qe(),a);a.f=ve(new ue(),a);}
function bf(a){af(a);return a;}
function df(c){var a,b,d;a=xe(c.f);Ae(c.f);b=null;if(Cd(a,7)){b=je(new ie(),Bd(a,7));}else{}if(b!==null){d=zc;}gf(c,false);ff(c);}
function ef(e,d){var a,b,c,f;f=false;try{gf(e,true);Be(e.f,e.b.b);sh(e.a,10000);while(ye(e.f)){b=ze(e.f);c=true;try{if(b===null){return;}if(Cd(b,7)){a=Bd(b,7);a.w();}else{}}finally{f=Ce(e.f);if(f){return;}if(c){Ae(e.f);}}if(kf(zw(),d)){return;}}}finally{if(!f){ph(e.a);gf(e,false);ff(e);}}}
function ff(a){if(!qz(a.b)&& !a.e&& !a.c){hf(a,true);sh(a.d,1);}}
function gf(b,a){b.c=a;}
function hf(b,a){b.e=a;}
function jf(b,a){iz(b.b,a);ff(b);}
function kf(a,b){return cv(a-b)>=100;}
function le(){}
_=le.prototype=new uv();_.tN=kC+'CommandExecutor';_.tI=0;_.c=false;_.e=false;function qh(){qh=fC;yh=gz(new ez());{xh();}}
function oh(a){qh();return a;}
function ph(a){if(a.b){th(a.c);}else{uh(a.c);}sz(yh,a);}
function rh(a){if(!a.b){sz(yh,a);}a.xb();}
function sh(b,a){if(a<=0){throw pu(new ou(),'must be positive');}ph(b);b.b=false;b.c=vh(b,a);iz(yh,b);}
function th(a){qh();$wnd.clearInterval(a);}
function uh(a){qh();$wnd.clearTimeout(a);}
function vh(b,a){qh();return $wnd.setTimeout(function(){b.x();},a);}
function wh(){var a;a=zc;{rh(this);}}
function xh(){qh();Dh(new kh());}
function jh(){}
_=jh.prototype=new uv();_.x=wh;_.tN=kC+'Timer';_.tI=16;_.b=false;_.c=0;var yh;function oe(){oe=fC;qh();}
function ne(b,a){oe();b.a=a;oh(b);return b;}
function pe(){if(!this.a.c){return;}df(this.a);}
function me(){}
_=me.prototype=new jh();_.xb=pe;_.tN=kC+'CommandExecutor$1';_.tI=17;function se(){se=fC;qh();}
function re(b,a){se();b.a=a;oh(b);return b;}
function te(){hf(this.a,false);ef(this.a,zw());}
function qe(){}
_=qe.prototype=new jh();_.xb=te;_.tN=kC+'CommandExecutor$2';_.tI=18;function ve(b,a){b.d=a;return b;}
function xe(a){return nz(a.d.b,a.b);}
function ye(a){return a.c<a.a;}
function ze(b){var a;b.b=b.c;a=nz(b.d.b,b.c++);if(b.c>=b.a){b.c=0;}return a;}
function Ae(a){rz(a.d.b,a.b);--a.a;if(a.b<=a.c){if(--a.c<0){a.c=0;}}a.b=(-1);}
function Be(b,a){b.a=a;}
function Ce(a){return a.b==(-1);}
function De(){return ye(this);}
function Ee(){return ze(this);}
function Fe(){Ae(this);}
function ue(){}
_=ue.prototype=new uv();_.F=De;_.cb=Ee;_.ub=Fe;_.tN=kC+'CommandExecutor$CircularIterator';_.tI=0;_.a=0;_.b=(-1);_.c=0;function nf(){nf=fC;mg=gz(new ez());{hg=new li();vi(hg);}}
function of(b,a){nf();xi(hg,b,a);}
function pf(a,b){nf();return si(hg,a,b);}
function qf(){nf();return zi(hg,'button');}
function rf(){nf();return zi(hg,'div');}
function sf(a){nf();return Ai(hg,a);}
function tf(){nf();return zi(hg,'tbody');}
function uf(){nf();return zi(hg,'td');}
function vf(){nf();return zi(hg,'tr');}
function wf(){nf();return zi(hg,'table');}
function xf(){nf();return zi(hg,'textarea');}
function Af(b,a,d){nf();var c;c=zc;{zf(b,a,d);}}
function zf(b,a,c){nf();var d;if(a===lg){if(bg(b)==8192){lg=null;}}d=yf;yf=b;try{c.eb(b);}finally{yf=d;}}
function Bf(b,a){nf();Bi(hg,b,a);}
function Cf(a){nf();return Ci(hg,a);}
function Df(a){nf();return Di(hg,a);}
function Ef(a){nf();return Ei(hg,a);}
function Ff(a){nf();return Fi(hg,a);}
function ag(a){nf();return aj(hg,a);}
function bg(a){nf();return bj(hg,a);}
function cg(a){nf();ti(hg,a);}
function eg(a,b){nf();return dj(hg,a,b);}
function dg(a,b){nf();return cj(hg,a,b);}
function fg(a){nf();return ej(hg,a);}
function gg(a){nf();return ui(hg,a);}
function ig(c,b,d,a){nf();ni(hg,c,b,d,a);}
function jg(a){nf();var b,c;c=true;if(mg.b>0){b=Fd(nz(mg,mg.b-1));if(!(c=null.bc())){Bf(a,true);cg(a);}}return c;}
function kg(b,a){nf();fj(hg,b,a);}
function pg(a,b,c){nf();ij(hg,a,b,c);}
function ng(a,b,c){nf();gj(hg,a,b,c);}
function og(a,b,c){nf();hj(hg,a,b,c);}
function qg(a,b){nf();jj(hg,a,b);}
function rg(a,b){nf();kj(hg,a,b);}
function sg(a,b){nf();lj(hg,a,b);}
function tg(b,a,c){nf();mj(hg,b,a,c);}
function ug(a,b){nf();wi(hg,a,b);}
function vg(){nf();return oi(hg);}
function wg(){nf();return pi(hg);}
var yf=null,hg=null,lg=null,mg;function yg(){yg=fC;Ag=bf(new le());}
function zg(a){yg();if(a===null){throw hv(new gv(),'cmd can not be null');}jf(Ag,a);}
var Ag;function Dg(a){if(Cd(a,8)){return pf(this,Bd(a,8));}return gd(ce(this,Bg),a);}
function Eg(){return hd(ce(this,Bg));}
function Bg(){}
_=Bg.prototype=new ed();_.eQ=Dg;_.hC=Eg;_.tN=kC+'Element';_.tI=19;function ch(a){return gd(ce(this,Fg),a);}
function dh(){return hd(ce(this,Fg));}
function Fg(){}
_=Fg.prototype=new ed();_.eQ=ch;_.hC=dh;_.tN=kC+'Event';_.tI=20;function fh(){fh=fC;hh=oj(new nj());}
function gh(c,b,a){fh();return qj(hh,c,b,a);}
var hh;function mh(){while((qh(),yh).b>0){ph(Bd(nz((qh(),yh),0),9));}}
function nh(){return null;}
function kh(){}
_=kh.prototype=new uv();_.nb=mh;_.ob=nh;_.tN=kC+'Timer$1';_.tI=21;function Ch(){Ch=fC;Fh=gz(new ez());ji=gz(new ez());{fi();}}
function Dh(a){Ch();iz(Fh,a);}
function Eh(a){Ch();iz(ji,a);}
function ai(){Ch();var a,b;for(a=Fh.ab();a.F();){b=Bd(a.cb(),10);b.nb();}}
function bi(){Ch();var a,b,c,d;d=null;for(a=Fh.ab();a.F();){b=Bd(a.cb(),10);c=b.ob();{d=c;}}return d;}
function ci(){Ch();var a,b;for(a=ji.ab();a.F();){b=Bd(a.cb(),11);b.pb(ei(),di());}}
function di(){Ch();return vg();}
function ei(){Ch();return wg();}
function fi(){Ch();__gwt_initHandlers(function(){ii();},function(){return hi();},function(){gi();$wnd.onresize=null;$wnd.onbeforeclose=null;$wnd.onclose=null;});}
function gi(){Ch();var a;a=zc;{ai();}}
function hi(){Ch();var a;a=zc;{return bi();}}
function ii(){Ch();var a;a=zc;{ci();}}
var Fh,ji;function xi(c,b,a){b.appendChild(a);}
function zi(b,a){return $doc.createElement(a);}
function Ai(c,a){var b;b=zi(c,'select');if(a){gj(c,b,'multiple',true);}return b;}
function Bi(c,b,a){b.cancelBubble=a;}
function Ci(b,a){return !(!a.altKey);}
function Di(b,a){return !(!a.ctrlKey);}
function Ei(b,a){return a.which||(a.keyCode|| -1);}
function Fi(b,a){return !(!a.metaKey);}
function aj(b,a){return !(!a.shiftKey);}
function bj(b,a){switch(a.type){case 'blur':return 4096;case 'change':return 1024;case 'click':return 1;case 'dblclick':return 2;case 'focus':return 2048;case 'keydown':return 128;case 'keypress':return 256;case 'keyup':return 512;case 'load':return 32768;case 'losecapture':return 8192;case 'mousedown':return 4;case 'mousemove':return 64;case 'mouseout':return 32;case 'mouseover':return 16;case 'mouseup':return 8;case 'scroll':return 16384;case 'error':return 65536;case 'mousewheel':return 131072;case 'DOMMouseScroll':return 131072;}}
function dj(d,a,b){var c=a[b];return c==null?null:String(c);}
function cj(d,a,c){var b=parseInt(a[c]);if(!b){return 0;}return b;}
function ej(b,a){return a.__eventBits||0;}
function fj(c,b,a){b.removeChild(a);}
function ij(c,a,b,d){a[b]=d;}
function gj(c,a,b,d){a[b]=d;}
function hj(c,a,b,d){a[b]=d;}
function jj(c,a,b){a.__listener=b;}
function kj(c,a,b){if(!b){b='';}a.innerHTML=b;}
function lj(c,a,b){while(a.firstChild){a.removeChild(a.firstChild);}if(b!=null){a.appendChild($doc.createTextNode(b));}}
function mj(c,b,a,d){b.style[a]=d;}
function ki(){}
_=ki.prototype=new uv();_.tN=lC+'DOMImpl';_.tI=0;function si(c,a,b){return a==b;}
function ti(b,a){a.preventDefault();}
function ui(c,a){var b=a.parentNode;if(b==null){return null;}if(b.nodeType!=1)b=null;return b||null;}
function vi(d){$wnd.__dispatchCapturedMouseEvent=function(b){if($wnd.__dispatchCapturedEvent(b)){var a=$wnd.__captureElem;if(a&&a.__listener){Af(b,a,a.__listener);b.stopPropagation();}}};$wnd.__dispatchCapturedEvent=function(a){if(!jg(a)){a.stopPropagation();a.preventDefault();return false;}return true;};$wnd.addEventListener('click',$wnd.__dispatchCapturedMouseEvent,true);$wnd.addEventListener('dblclick',$wnd.__dispatchCapturedMouseEvent,true);$wnd.addEventListener('mousedown',$wnd.__dispatchCapturedMouseEvent,true);$wnd.addEventListener('mouseup',$wnd.__dispatchCapturedMouseEvent,true);$wnd.addEventListener('mousemove',$wnd.__dispatchCapturedMouseEvent,true);$wnd.addEventListener('mousewheel',$wnd.__dispatchCapturedMouseEvent,true);$wnd.addEventListener('keydown',$wnd.__dispatchCapturedEvent,true);$wnd.addEventListener('keyup',$wnd.__dispatchCapturedEvent,true);$wnd.addEventListener('keypress',$wnd.__dispatchCapturedEvent,true);$wnd.__dispatchEvent=function(b){var c,a=this;while(a&& !(c=a.__listener))a=a.parentNode;if(a&&a.nodeType!=1)a=null;if(c)Af(b,a,c);};$wnd.__captureElem=null;}
function wi(c,b,a){b.__eventBits=a;b.onclick=a&1?$wnd.__dispatchEvent:null;b.ondblclick=a&2?$wnd.__dispatchEvent:null;b.onmousedown=a&4?$wnd.__dispatchEvent:null;b.onmouseup=a&8?$wnd.__dispatchEvent:null;b.onmouseover=a&16?$wnd.__dispatchEvent:null;b.onmouseout=a&32?$wnd.__dispatchEvent:null;b.onmousemove=a&64?$wnd.__dispatchEvent:null;b.onkeydown=a&128?$wnd.__dispatchEvent:null;b.onkeypress=a&256?$wnd.__dispatchEvent:null;b.onkeyup=a&512?$wnd.__dispatchEvent:null;b.onchange=a&1024?$wnd.__dispatchEvent:null;b.onfocus=a&2048?$wnd.__dispatchEvent:null;b.onblur=a&4096?$wnd.__dispatchEvent:null;b.onlosecapture=a&8192?$wnd.__dispatchEvent:null;b.onscroll=a&16384?$wnd.__dispatchEvent:null;b.onload=a&32768?$wnd.__dispatchEvent:null;b.onerror=a&65536?$wnd.__dispatchEvent:null;b.onmousewheel=a&131072?$wnd.__dispatchEvent:null;}
function qi(){}
_=qi.prototype=new ki();_.tN=lC+'DOMImplStandard';_.tI=0;function ni(e,c,d,f,a){var b=new Option(d,f);if(a== -1||a>c.children.length-1){c.appendChild(b);}else{c.insertBefore(b,c.children[a]);}}
function oi(a){return $wnd.innerHeight;}
function pi(a){return $wnd.innerWidth;}
function li(){}
_=li.prototype=new qi();_.tN=lC+'DOMImplSafari';_.tI=0;function oj(a){uj=jd();return a;}
function qj(c,d,b,a){return rj(c,null,null,d,b,a);}
function rj(d,f,c,e,b,a){return pj(d,f,c,e,b,a);}
function pj(e,g,d,f,c,b){var h=e.t();try{h.open('POST',f,true);h.setRequestHeader('Content-Type','text/plain; charset=utf-8');h.onreadystatechange=function(){if(h.readyState==4){h.onreadystatechange=uj;b.hb(h.responseText||'');}};h.send(c);return true;}catch(a){h.onreadystatechange=uj;return false;}}
function tj(){return new XMLHttpRequest();}
function nj(){}
_=nj.prototype=new uv();_.t=tj;_.tN=lC+'HTTPRequestImpl';_.tI=0;var uj=null;function xj(a){zv(a,'This application is out of date, please click the refresh button on your browser');return a;}
function wj(){}
_=wj.prototype=new yv();_.tN=mC+'IncompatibleRemoteServiceException';_.tI=22;function Bj(b,a){}
function Cj(b,a){}
function Ej(b,a){Av(b,a,null);return b;}
function Dj(){}
_=Dj.prototype=new yv();_.tN=mC+'InvocationException';_.tI=23;function ck(b,a){lu(b,a);return b;}
function bk(){}
_=bk.prototype=new ku();_.tN=mC+'SerializationException';_.tI=24;function hk(a){Ej(a,'Service implementation URL not specified');return a;}
function gk(){}
_=gk.prototype=new Dj();_.tN=mC+'ServiceDefTarget$NoServiceEntryPointSpecifiedException';_.tI=25;function mk(b,a){}
function nk(a){return yu(new xu(),a.rb());}
function ok(b,a){b.Db(a.a);}
function rk(b,a){}
function sk(a){return a.tb();}
function tk(b,a){b.Fb(a);}
function wk(e,b){var a,c,d;d=e.rb();for(a=0;a<d;++a){c=e.sb();iz(b,c);}}
function xk(e,a){var b,c,d;d=a.b;e.Db(d);b=a.ab();while(b.F()){c=b.cb();e.Eb(c);}}
function Ak(e,b){var a,c,d;d=e.rb();for(a=0;a<d;++a){c=e.sb();BB(b,c);}}
function Bk(e,a){var b,c,d;d=a.a.b;e.Db(d);b=DB(a);while(b.F()){c=b.cb();e.Eb(c);}}
function pl(a){return a.j>2;}
function ql(b,a){b.i=a;}
function rl(a,b){a.j=b;}
function Ck(){}
_=Ck.prototype=new uv();_.tN=pC+'AbstractSerializationStream';_.tI=0;_.i=0;_.j=3;function Ek(a){a.e=gz(new ez());}
function Fk(a){Ek(a);return a;}
function bl(b,a){kz(b.e);rl(b,xl(b));ql(b,xl(b));}
function cl(a){var b,c;b=a.rb();if(b<0){return nz(a.e,-(b+1));}c=a.B(b);if(c===null){return null;}return a.r(c);}
function dl(b,a){iz(b.e,a);}
function el(){return cl(this);}
function Dk(){}
_=Dk.prototype=new Ck();_.sb=el;_.tN=pC+'AbstractSerializationStreamReader';_.tI=0;function hl(b,a){b.o(ww(a));}
function il(c,a){var b,d;if(a===null){jl(c,null);return;}b=c.y(a);if(b>=0){hl(c,-(b+1));return;}c.yb(a);d=c.A(a);jl(c,d);c.zb(a,d);}
function jl(a,b){hl(a,a.l(b));}
function kl(a){this.o(vw(a));}
function ll(a){hl(this,a);}
function ml(a){il(this,a);}
function nl(a){jl(this,a);}
function fl(){}
_=fl.prototype=new Ck();_.Cb=kl;_.Db=ll;_.Eb=ml;_.Fb=nl;_.tN=pC+'AbstractSerializationStreamWriter';_.tI=0;function tl(b,a){Fk(b);b.c=a;return b;}
function vl(b,a){if(!a){return null;}return b.d[a-1];}
function wl(b,a){b.b=Al(a);b.a=Bl(b.b);bl(b,a);b.d=yl(b);}
function xl(a){return a.b[--a.a];}
function yl(a){return a.b[--a.a];}
function zl(b){var a;a=jc(this.c,this,b);dl(this,a);hc(this.c,this,a,b);return a;}
function Al(a){return eval(a);}
function Bl(a){return a.length;}
function Cl(a){return vl(this,a);}
function Dl(){return this.b[--this.a];}
function El(){return xl(this);}
function Fl(){return vl(this,xl(this));}
function sl(){}
_=sl.prototype=new Dk();_.r=zl;_.B=Cl;_.qb=Dl;_.rb=El;_.tb=Fl;_.tN=pC+'ClientSerializationStreamReader';_.tI=0;_.a=0;_.b=null;_.c=null;_.d=null;function bm(a){a.h=gz(new ez());}
function cm(d,c,a,b){bm(d);d.f=c;d.b=a;d.e=b;return d;}
function em(c,a){var b=c.d[a];return b==null?-1:b;}
function fm(c,a){var b=c.g[':'+a];return b==null?0:b;}
function gm(a){a.c=0;a.d=kd();a.g=kd();kz(a.h);a.a=Ev(new Dv());if(pl(a)){jl(a,a.b);jl(a,a.e);}}
function hm(b,a,c){b.d[a]=c;}
function im(b,a,c){b.g[':'+a]=c;}
function jm(b){var a;a=Ev(new Dv());km(b,a);mm(b,a);lm(b,a);return ew(a);}
function km(b,a){om(a,ww(b.j));om(a,ww(b.i));}
function lm(b,a){aw(a,ew(b.a));}
function mm(d,a){var b,c;c=d.h.b;om(a,ww(c));for(b=0;b<c;++b){om(a,Bd(nz(d.h,b),1));}return a;}
function nm(b){var a;if(b===null){return 0;}a=fm(this,b);if(a>0){return a;}iz(this.h,b);a=this.h.b;im(this,b,a);return a;}
function om(a,b){aw(a,b);Fv(a,65535);}
function pm(a){om(this.a,a);}
function qm(a){return em(this,Aw(a));}
function rm(a){var b,c;c=yc(a);b=ic(this.f,c);if(b!==null){c+='/'+b;}return c;}
function sm(a){hm(this,Aw(a),this.c++);}
function tm(a,b){kc(this.f,this,a,b);}
function am(){}
_=am.prototype=new fl();_.l=nm;_.o=pm;_.y=qm;_.A=rm;_.yb=sm;_.zb=tm;_.tN=pC+'ClientSerializationStreamWriter';_.tI=0;_.a=null;_.b=null;_.c=0;_.d=null;_.e=null;_.f=null;_.g=null;function Cr(b,a){Dr(b,Fr(b)+Ad(45)+a);}
function Dr(b,a){ks(b.i,a,true);}
function Fr(a){return is(a.i);}
function as(b,a){bs(b,Fr(b)+Ad(45)+a);}
function bs(b,a){ks(b.i,a,false);}
function cs(d,b,a){var c=b.parentNode;if(!c){return;}c.insertBefore(a,b);c.removeChild(b);}
function ds(b,a){if(b.i!==null){cs(b,b.i,a);}b.i=a;}
function es(b,a){js(b.i,a);}
function fs(a,b){tg(a.i,'width',b);}
function gs(b,a){ug(b.i,a|fg(b.i));}
function hs(a){return eg(a,'className');}
function is(a){var b,c;b=hs(a);c=iw(b,32);if(c>=0){return ow(b,0,c);}return b;}
function js(a,b){pg(a,'className',b);}
function ks(c,j,a){var b,d,e,f,g,h,i;if(c===null){throw zv(new yv(),'Null widget handle. If you are creating a composite, ensure that initWidget() has been called.');}j=pw(j);if(lw(j)==0){throw pu(new ou(),'Style names cannot be empty');}i=hs(c);e=jw(i,j);while(e!=(-1)){if(e==0||gw(i,e-1)==32){f=e+lw(j);g=lw(i);if(f==g||f<g&&gw(i,f)==32){break;}}e=kw(i,j,e+1);}if(a){if(e==(-1)){if(lw(i)>0){i+=' ';}pg(c,'className',i+j);}}else{if(e!=(-1)){b=pw(ow(i,0,e));d=pw(nw(i,e+lw(j)));if(lw(b)==0){h=d;}else if(lw(d)==0){h=b;}else{h=b+' '+d;}pg(c,'className',h);}}}
function Br(){}
_=Br.prototype=new uv();_.tN=qC+'UIObject';_.tI=0;_.i=null;function ft(a){if(a.g){throw su(new ru(),"Should only call onAttach when the widget is detached from the browser's document");}a.g=true;qg(a.i,a);a.s();a.lb();}
function gt(a){if(!a.g){throw su(new ru(),"Should only call onDetach when the widget is attached to the browser's document");}try{a.mb();}finally{a.u();qg(a.i,null);a.g=false;}}
function ht(a){if(a.h!==null){a.h.wb(a);}else if(a.h!==null){throw su(new ru(),"This widget's parent does not implement HasWidgets");}}
function it(b,a){if(b.g){qg(b.i,null);}ds(b,a);if(b.g){qg(a,b);}}
function jt(c,b){var a;a=c.h;if(b===null){if(a!==null&&a.g){gt(c);}c.h=null;}else{if(a!==null){throw su(new ru(),'Cannot set a new parent without first clearing the old parent');}c.h=b;if(b.g){ft(c);}}}
function kt(){}
function lt(){}
function mt(a){}
function nt(){}
function ot(){}
function pt(a){it(this,a);}
function ss(){}
_=ss.prototype=new Br();_.s=kt;_.u=lt;_.eb=mt;_.lb=nt;_.mb=ot;_.Ab=pt;_.tN=qC+'Widget';_.tI=26;_.g=false;_.h=null;function tq(b,a){jt(a,b);}
function vq(b,a){jt(a,null);}
function wq(){var a,b;for(b=this.ab();xs(b);){a=ys(b);ft(a);}}
function xq(){var a,b;for(b=this.ab();xs(b);){a=ys(b);gt(a);}}
function yq(){}
function zq(){}
function sq(){}
_=sq.prototype=new ss();_.s=wq;_.u=xq;_.lb=yq;_.mb=zq;_.tN=qC+'Panel';_.tI=27;function xn(a){a.f=Cs(new ts(),a);}
function yn(a){xn(a);return a;}
function zn(c,a,b){ht(a);Ds(c.f,a);of(b,a.i);tq(c,a);}
function Bn(b,c){var a;if(c.h!==b){return false;}vq(b,c);a=c.i;kg(gg(a),a);dt(b.f,c);return true;}
function Cn(){return bt(this.f);}
function Dn(a){return Bn(this,a);}
function wn(){}
_=wn.prototype=new sq();_.ab=Cn;_.wb=Dn;_.tN=qC+'ComplexPanel';_.tI=28;function wm(a){yn(a);a.Ab(rf());tg(a.i,'position','relative');tg(a.i,'overflow','hidden');return a;}
function xm(a,b){zn(a,b,a.i);}
function zm(a){tg(a,'left','');tg(a,'top','');tg(a,'position','');}
function Am(b){var a;a=Bn(this,b);if(a){zm(b.i);}return a;}
function vm(){}
_=vm.prototype=new wn();_.wb=Am;_.tN=qC+'AbsolutePanel';_.tI=29;function ao(){ao=fC;Ct(),Et;}
function Fn(b,a){Ct(),Et;co(b,a);return b;}
function bo(b,a){switch(bg(a)){case 1:if(b.d!==null){un(b.d,b);}break;case 4096:case 2048:break;case 128:case 512:case 256:break;}}
function co(b,a){it(b,a);gs(b,7041);}
function eo(b,a){ng(b.i,'disabled',!a);}
function fo(a){if(this.d===null){this.d=sn(new rn());}iz(this.d,a);}
function go(a){bo(this,a);}
function ho(a){co(this,a);}
function En(){}
_=En.prototype=new ss();_.k=fo;_.eb=go;_.Ab=ho;_.tN=qC+'FocusWidget';_.tI=30;_.d=null;function Em(){Em=fC;Ct(),Et;}
function Dm(b,a){Ct(),Et;Fn(b,a);return b;}
function Fm(b,a){rg(b.i,a);}
function Cm(){}
_=Cm.prototype=new En();_.tN=qC+'ButtonBase';_.tI=31;function cn(){cn=fC;Ct(),Et;}
function an(a){Ct(),Et;Dm(a,qf());dn(a.i);es(a,'gwt-Button');return a;}
function bn(b,a){Ct(),Et;an(b);Fm(b,a);return b;}
function dn(b){cn();if(b.type=='submit'){try{b.setAttribute('type','button');}catch(a){}}}
function Bm(){}
_=Bm.prototype=new Cm();_.tN=qC+'Button';_.tI=32;function fn(a){yn(a);a.e=wf();a.d=tf();of(a.e,a.d);a.Ab(a.e);return a;}
function hn(a,b){if(b.h!==a){return null;}return gg(b.i);}
function kn(c,d,a){var b;b=hn(c,d);if(b!==null){jn(c,b,a);}}
function jn(c,b,a){pg(b,'align',a.a);}
function ln(c,b,a){tg(b,'verticalAlign',a.a);}
function en(){}
_=en.prototype=new wn();_.tN=qC+'CellPanel';_.tI=33;_.d=null;_.e=null;function dx(d,a,b){var c;while(a.F()){c=a.cb();if(b===null?c===null:b.eQ(c)){return a;}}return null;}
function fx(a){throw ax(new Fw(),'add');}
function gx(b){var a;a=dx(this,this.ab(),b);return a!==null;}
function cx(){}
_=cx.prototype=new uv();_.n=fx;_.q=gx;_.tN=tC+'AbstractCollection';_.tI=0;function qx(b,a){throw vu(new uu(),'Index: '+a+', Size: '+b.b);}
function rx(b,a){throw ax(new Fw(),'add');}
function sx(a){this.m(this.Bb(),a);return true;}
function tx(e){var a,b,c,d,f;if(e===this){return true;}if(!Cd(e,2)){return false;}f=Bd(e,2);if(this.Bb()!=f.Bb()){return false;}c=this.ab();d=f.ab();while(c.F()){a=c.cb();b=d.cb();if(!(a===null?b===null:a.eQ(b))){return false;}}return true;}
function ux(){var a,b,c,d;c=1;a=31;b=this.ab();while(b.F()){d=b.cb();c=31*c+(d===null?0:d.hC());}return c;}
function vx(){return jx(new ix(),this);}
function wx(a){throw ax(new Fw(),'remove');}
function hx(){}
_=hx.prototype=new cx();_.m=rx;_.n=sx;_.eQ=tx;_.hC=ux;_.ab=vx;_.vb=wx;_.tN=tC+'AbstractList';_.tI=34;function fz(a){{jz(a);}}
function gz(a){fz(a);return a;}
function hz(c,a,b){if(a<0||a>c.b){qx(c,a);}tz(c.a,a,b);++c.b;}
function iz(b,a){Cz(b.a,b.b++,a);return true;}
function kz(a){jz(a);}
function jz(a){a.a=id();a.b=0;}
function mz(b,a){return oz(b,a)!=(-1);}
function nz(b,a){if(a<0||a>=b.b){qx(b,a);}return yz(b.a,a);}
function oz(b,a){return pz(b,a,0);}
function pz(c,b,a){if(a<0){qx(c,a);}for(;a<c.b;++a){if(xz(b,yz(c.a,a))){return a;}}return (-1);}
function qz(a){return a.b==0;}
function rz(c,a){var b;b=nz(c,a);Az(c.a,a,1);--c.b;return b;}
function sz(c,b){var a;a=oz(c,b);if(a==(-1)){return false;}rz(c,a);return true;}
function uz(a,b){hz(this,a,b);}
function vz(a){return iz(this,a);}
function tz(a,b,c){a.splice(b,0,c);}
function wz(a){return mz(this,a);}
function xz(a,b){return a===b||a!==null&&a.eQ(b);}
function zz(a){return nz(this,a);}
function yz(a,b){return a[b];}
function Bz(a){return rz(this,a);}
function Az(a,c,b){a.splice(c,b);}
function Cz(a,b,c){a[b]=c;}
function Dz(){return this.b;}
function ez(){}
_=ez.prototype=new hx();_.m=uz;_.n=vz;_.q=wz;_.D=zz;_.vb=Bz;_.Bb=Dz;_.tN=tC+'ArrayList';_.tI=35;_.a=null;_.b=0;function nn(a){gz(a);return a;}
function pn(d,c){var a,b;for(a=d.ab();a.F();){b=Bd(a.cb(),12);b.fb(c);}}
function mn(){}
_=mn.prototype=new ez();_.tN=qC+'ChangeListenerCollection';_.tI=36;function sn(a){gz(a);return a;}
function un(d,c){var a,b;for(a=d.ab();a.F();){b=Bd(a.cb(),13);b.gb(c);}}
function rn(){}
_=rn.prototype=new ez();_.tN=qC+'ClickListenerCollection';_.tI=37;function wp(a){a.Ab(rf());gs(a,131197);es(a,'gwt-Label');return a;}
function xp(b,a){wp(b);zp(b,a);return b;}
function zp(b,a){sg(b.i,a);}
function Ap(a){switch(bg(a)){case 1:break;case 4:case 8:case 64:case 16:case 32:break;case 131072:break;}}
function vp(){}
_=vp.prototype=new ss();_.eb=Ap;_.tN=qC+'Label';_.tI=38;function jo(a){wp(a);a.Ab(rf());gs(a,125);es(a,'gwt-HTML');return a;}
function ko(b,a){jo(b);mo(b,a);return b;}
function mo(b,a){rg(b.i,a);}
function io(){}
_=io.prototype=new vp();_.tN=qC+'HTML';_.tI=39;function to(){to=fC;ro(new qo(),'center');uo=ro(new qo(),'left');vo=ro(new qo(),'right');}
var uo,vo;function ro(b,a){b.a=a;return b;}
function qo(){}
_=qo.prototype=new uv();_.tN=qC+'HasHorizontalAlignment$HorizontalAlignmentConstant';_.tI=0;_.a=null;function Bo(){Bo=fC;zo(new yo(),'bottom');zo(new yo(),'middle');Co=zo(new yo(),'top');}
var Co;function zo(a,b){a.a=b;return a;}
function yo(){}
_=yo.prototype=new uv();_.tN=qC+'HasVerticalAlignment$VerticalAlignmentConstant';_.tI=0;_.a=null;function ap(a){a.a=(to(),uo);a.c=(Bo(),Co);}
function bp(a){fn(a);ap(a);a.b=vf();of(a.d,a.b);pg(a.e,'cellSpacing','0');pg(a.e,'cellPadding','0');return a;}
function cp(b,c){var a;a=ep(b);of(b.b,a);zn(b,c,a);}
function ep(b){var a;a=uf();jn(b,a,b.a);ln(b,a,b.c);return a;}
function fp(c){var a,b;b=gg(c.i);a=Bn(this,c);if(a){kg(this.b,b);}return a;}
function Fo(){}
_=Fo.prototype=new en();_.wb=fp;_.tN=qC+'HorizontalPanel';_.tI=40;_.b=null;function np(a){gz(a);return a;}
function pp(f,e,b,d){var a,c;for(a=f.ab();a.F();){c=Bd(a.cb(),14);c.ib(e,b,d);}}
function qp(f,e,b,d){var a,c;for(a=f.ab();a.F();){c=Bd(a.cb(),14);c.jb(e,b,d);}}
function rp(f,e,b,d){var a,c;for(a=f.ab();a.F();){c=Bd(a.cb(),14);c.kb(e,b,d);}}
function sp(d,c,a){var b;b=tp(a);switch(bg(a)){case 128:pp(d,c,Dd(Ef(a)),b);break;case 512:rp(d,c,Dd(Ef(a)),b);break;case 256:qp(d,c,Dd(Ef(a)),b);break;}}
function tp(a){return (ag(a)?1:0)|(Ff(a)?8:0)|(Df(a)?2:0)|(Cf(a)?4:0);}
function mp(){}
_=mp.prototype=new ez();_.tN=qC+'KeyboardListenerCollection';_.tI=41;function hq(){hq=fC;Ct(),Et;qq=new Dp();}
function dq(a){hq();eq(a,false);return a;}
function eq(b,a){hq();Fn(b,sf(a));gs(b,1024);es(b,'gwt-ListBox');return b;}
function fq(b,a){lq(b,a,(-1));}
function gq(b,a){if(a<0||a>=iq(b)){throw new uu();}}
function iq(a){return Fp(qq,a.i);}
function jq(a){return dg(a.i,'selectedIndex');}
function kq(b,a){gq(b,a);return aq(qq,b.i,a);}
function lq(c,b,a){mq(c,b,b,a);}
function mq(c,b,d,a){ig(c.i,b,d,a);}
function nq(c,a,b){gq(c,a);bq(qq,c.i,a,b);}
function oq(b,a){ng(b.i,'multiple',a);}
function pq(a,b){og(a.i,'size',b);}
function rq(a){if(bg(a)==1024){}else{bo(this,a);}}
function Bp(){}
_=Bp.prototype=new En();_.eb=rq;_.tN=qC+'ListBox';_.tI=42;var qq;function Cp(){}
_=Cp.prototype=new uv();_.tN=qC+'ListBox$Impl';_.tI=0;function Fp(b,a){return a.children.length;}
function aq(c,b,a){return b.children[a].value;}
function bq(d,b,a,c){b.children[a].selected=c;}
function Dp(){}
_=Dp.prototype=new Cp();_.tN=qC+'ListBox$ImplSafari';_.tI=0;function ar(){ar=fC;fr=AA(new aA());}
function Fq(b,a){ar();wm(b);if(a===null){a=br();}b.Ab(a);ft(b);return b;}
function cr(){ar();return dr(null);}
function dr(c){ar();var a,b;b=Bd(aB(fr,c),15);if(b!==null){return b;}a=null;if(fr.c==0){er();}bB(fr,c,b=Fq(new Aq(),a));return b;}
function br(){ar();return $doc.body;}
function er(){ar();Dh(new Bq());}
function Aq(){}
_=Aq.prototype=new vm();_.tN=qC+'RootPanel';_.tI=43;var fr;function Dq(){var a,b;for(b=ky(zy((ar(),fr)));ry(b);){a=Bd(sy(b),15);if(a.g){gt(a);}}}
function Eq(){return null;}
function Bq(){}
_=Bq.prototype=new uv();_.nb=Dq;_.ob=Eq;_.tN=qC+'RootPanel$1';_.tI=44;function vr(){vr=fC;Ct(),Et;}
function sr(b,a){Ct(),Et;Fn(b,a);gs(b,1024);return b;}
function tr(b,a){if(b.a===null){b.a=nn(new mn());}iz(b.a,a);}
function ur(b,a){if(b.c===null){b.c=np(new mp());}iz(b.c,a);}
function wr(a){return eg(a.i,'value');}
function xr(c,a){var b;ng(c.i,'readOnly',a);b='readonly';if(a){Cr(c,b);}else{as(c,b);}}
function yr(b,a){pg(b.i,'value',a!==null?a:'');}
function zr(a){if(this.b===null){this.b=sn(new rn());}iz(this.b,a);}
function Ar(a){var b;bo(this,a);b=bg(a);if(this.c!==null&&(b&896)!=0){sp(this.c,this,a);}else if(b==1){if(this.b!==null){un(this.b,this);}}else if(b==1024){if(this.a!==null){pn(this.a,this);}}}
function rr(){}
_=rr.prototype=new En();_.k=zr;_.eb=Ar;_.tN=qC+'TextBoxBase';_.tI=45;_.a=null;_.b=null;_.c=null;function or(){or=fC;Ct(),Et;}
function nr(a){Ct(),Et;sr(a,xf());es(a,'gwt-TextArea');return a;}
function pr(a,b){og(a.i,'cols',b);}
function qr(b,a){og(b.i,'rows',a);}
function mr(){}
_=mr.prototype=new rr();_.tN=qC+'TextArea';_.tI=46;function ms(a){a.a=(to(),uo);a.b=(Bo(),Co);}
function ns(a){fn(a);ms(a);pg(a.e,'cellSpacing','0');pg(a.e,'cellPadding','0');return a;}
function os(b,d){var a,c;c=vf();a=qs(b);of(c,a);of(b.d,c);zn(b,d,a);}
function qs(b){var a;a=uf();jn(b,a,b.a);ln(b,a,b.b);return a;}
function rs(c){var a,b;b=gg(c.i);a=Bn(this,c);if(a){kg(this.d,gg(b));}return a;}
function ls(){}
_=ls.prototype=new en();_.wb=rs;_.tN=qC+'VerticalPanel';_.tI=47;function Cs(b,a){b.b=a;b.a=vd('[Lcom.google.gwt.user.client.ui.Widget;',[0],[17],[4],null);return b;}
function Ds(a,b){at(a,b,a.c);}
function Fs(b,c){var a;for(a=0;a<b.c;++a){if(b.a[a]===c){return a;}}return (-1);}
function at(d,e,a){var b,c;if(a<0||a>d.c){throw new uu();}if(d.c==d.a.a){c=vd('[Lcom.google.gwt.user.client.ui.Widget;',[0],[17],[d.a.a*2],null);for(b=0;b<d.a.a;++b){wd(c,b,d.a[b]);}d.a=c;}++d.c;for(b=d.c-1;b>a;--b){wd(d.a,b,d.a[b-1]);}wd(d.a,a,e);}
function bt(a){return vs(new us(),a);}
function ct(c,b){var a;if(b<0||b>=c.c){throw new uu();}--c.c;for(a=b;a<c.c;++a){wd(c.a,a,c.a[a+1]);}wd(c.a,c.c,null);}
function dt(b,c){var a;a=Fs(b,c);if(a==(-1)){throw new vB();}ct(b,a);}
function ts(){}
_=ts.prototype=new uv();_.tN=qC+'WidgetCollection';_.tI=0;_.a=null;_.b=null;_.c=0;function vs(b,a){b.b=a;return b;}
function xs(a){return a.a<a.b.c-1;}
function ys(a){if(a.a>=a.b.c){throw new vB();}return a.b.a[++a.a];}
function zs(){return xs(this);}
function As(){return ys(this);}
function Bs(){if(this.a<0||this.a>=this.b.c){throw new ru();}this.b.b.wb(this.b.a[this.a--]);}
function us(){}
_=us.prototype=new uv();_.F=zs;_.cb=As;_.ub=Bs;_.tN=qC+'WidgetCollection$WidgetIterator';_.tI=0;_.a=(-1);function Ct(){Ct=fC;Dt=yt(new xt());Et=Dt!==null?Bt(new qt()):Dt;}
function Bt(a){Ct();return a;}
function qt(){}
_=qt.prototype=new uv();_.tN=rC+'FocusImpl';_.tI=0;var Dt,Et;function ut(){ut=fC;Ct();}
function st(a){vt(a);wt(a);At(a);}
function tt(a){ut();Bt(a);st(a);return a;}
function vt(b){return function(a){if(this.parentNode.onblur){this.parentNode.onblur(a);}};}
function wt(b){return function(a){if(this.parentNode.onfocus){this.parentNode.onfocus(a);}};}
function rt(){}
_=rt.prototype=new qt();_.tN=rC+'FocusImplOld';_.tI=0;function zt(){zt=fC;ut();}
function yt(a){zt();tt(a);return a;}
function At(b){return function(){var a=this.firstChild;$wnd.setTimeout(function(){a.focus();},0);};}
function xt(){}
_=xt.prototype=new rt();_.tN=rC+'FocusImplSafari';_.tI=0;function au(){}
_=au.prototype=new yv();_.tN=sC+'ArrayStoreException';_.tI=48;function fu(a,b){if(b<2||b>36){return (-1);}if(a>=48&&a<48+dv(b,10)){return a-48;}if(a>=97&&a<b+97-10){return a-97+10;}if(a>=65&&a<b+65-10){return a-65+10;}return (-1);}
function gu(){}
_=gu.prototype=new yv();_.tN=sC+'ClassCastException';_.tI=49;function pu(b,a){zv(b,a);return b;}
function ou(){}
_=ou.prototype=new yv();_.tN=sC+'IllegalArgumentException';_.tI=50;function su(b,a){zv(b,a);return b;}
function ru(){}
_=ru.prototype=new yv();_.tN=sC+'IllegalStateException';_.tI=51;function vu(b,a){zv(b,a);return b;}
function uu(){}
_=uu.prototype=new yv();_.tN=sC+'IndexOutOfBoundsException';_.tI=52;function ov(){ov=fC;{tv();}}
function nv(a){ov();return a;}
function pv(a){ov();return isNaN(a);}
function qv(e,d,c,h){ov();var a,b,f,g;if(e===null){throw lv(new kv(),'Unable to parse null');}b=lw(e);f=b>0&&gw(e,0)==45?1:0;for(a=f;a<b;a++){if(fu(gw(e,a),d)==(-1)){throw lv(new kv(),'Could not parse '+e+' in radix '+d);}}g=rv(e,d);if(pv(g)){throw lv(new kv(),'Unable to parse '+e);}else if(g<c||g>h){throw lv(new kv(),'The string '+e+' exceeds the range for the requested data type');}return g;}
function rv(b,a){ov();return parseInt(b,a);}
function tv(){ov();sv=/^[+-]?\d*\.?\d*(e[+-]?\d+)?$/i;}
function jv(){}
_=jv.prototype=new uv();_.tN=sC+'Number';_.tI=0;var sv=null;function zu(){zu=fC;ov();}
function yu(a,b){zu();nv(a);a.a=b;return a;}
function Au(a){return Cd(a,20)&&Bd(a,20).a==this.a;}
function Bu(){return this.a;}
function Cu(a){zu();return Du(a,10);}
function Du(b,a){zu();return Ed(qv(b,a,(-2147483648),2147483647));}
function Eu(a){zu();return ww(a);}
function Fu(a){zu();return yu(new xu(),Cu(a));}
function xu(){}
_=xu.prototype=new jv();_.eQ=Au;_.hC=Bu;_.tN=sC+'Integer';_.tI=53;_.a=0;function cv(a){return a<0?-a:a;}
function dv(a,b){return a<b?a:b;}
function ev(){}
_=ev.prototype=new yv();_.tN=sC+'NegativeArraySizeException';_.tI=54;function hv(b,a){zv(b,a);return b;}
function gv(){}
_=gv.prototype=new yv();_.tN=sC+'NullPointerException';_.tI=55;function lv(b,a){pu(b,a);return b;}
function kv(){}
_=kv.prototype=new ou();_.tN=sC+'NumberFormatException';_.tI=56;function gw(b,a){return b.charCodeAt(a);}
function iw(b,a){return b.indexOf(String.fromCharCode(a));}
function jw(b,a){return b.indexOf(a);}
function kw(c,b,a){return c.indexOf(b,a);}
function lw(a){return a.length;}
function mw(b,a){return jw(b,a)==0;}
function nw(b,a){return b.substr(a,b.length-a);}
function ow(c,a,b){return c.substr(a,b-a);}
function pw(c){var a=c.replace(/^(\s*)/,'');var b=a.replace(/\s*$/,'');return b;}
function qw(a,b){return String(a)==b;}
function rw(a){if(!Cd(a,1))return false;return qw(this,a);}
function tw(){var a=sw;if(!a){a=sw={};}var e=':'+this;var b=a[e];if(b==null){b=0;var f=this.length;var d=f<64?1:f/32|0;for(var c=0;c<f;c+=d){b<<=1;b+=this.charCodeAt(c);}b|=0;a[e]=b;}return b;}
function uw(a){return String.fromCharCode(a);}
function vw(a){return ''+a;}
function ww(a){return ''+a;}
_=String.prototype;_.eQ=rw;_.hC=tw;_.tN=sC+'String';_.tI=2;var sw=null;function Ev(a){bw(a);return a;}
function Fv(a,b){return aw(a,uw(b));}
function aw(c,d){if(d===null){d='null';}var a=c.js.length-1;var b=c.js[a].length;if(c.length>b*b){c.js[a]=c.js[a]+d;}else{c.js.push(d);}c.length+=d.length;return c;}
function bw(a){cw(a,'');}
function cw(b,a){b.js=[a];b.length=a.length;}
function ew(a){a.db();return a.js[0];}
function fw(){if(this.js.length>1){this.js=[this.js.join('')];this.length=this.js[0].length;}}
function Dv(){}
_=Dv.prototype=new uv();_.db=fw;_.tN=sC+'StringBuffer';_.tI=0;function zw(){return new Date().getTime();}
function Aw(a){return Dc(a);}
function ax(b,a){zv(b,a);return b;}
function Fw(){}
_=Fw.prototype=new yv();_.tN=sC+'UnsupportedOperationException';_.tI=57;function jx(b,a){b.c=a;return b;}
function lx(a){return a.a<a.c.Bb();}
function mx(){return lx(this);}
function nx(){if(!lx(this)){throw new vB();}return this.c.D(this.b=this.a++);}
function ox(){if(this.b<0){throw new ru();}this.c.vb(this.b);this.a=this.b;this.b=(-1);}
function ix(){}
_=ix.prototype=new uv();_.F=mx;_.cb=nx;_.ub=ox;_.tN=tC+'AbstractList$IteratorImpl';_.tI=0;_.a=0;_.b=(-1);function xy(f,d,e){var a,b,c;for(b=vA(f.v());nA(b);){a=oA(b);c=a.z();if(d===null?c===null:d.eQ(c)){if(e){pA(b);}return a;}}return null;}
function yy(b){var a;a=b.v();return zx(new yx(),b,a);}
function zy(b){var a;a=FA(b);return iy(new hy(),b,a);}
function Ay(a){return xy(this,a,false)!==null;}
function By(d){var a,b,c,e,f,g,h;if(d===this){return true;}if(!Cd(d,21)){return false;}f=Bd(d,21);c=yy(this);e=f.bb();if(!bz(c,e)){return false;}for(a=Bx(c);cy(a);){b=dy(a);h=this.E(b);g=f.E(b);if(h===null?g!==null:!h.eQ(g)){return false;}}return true;}
function Cy(b){var a;a=xy(this,b,false);return a===null?null:a.C();}
function Dy(){var a,b,c;b=0;for(c=vA(this.v());nA(c);){a=oA(c);b+=a.hC();}return b;}
function Ey(){return yy(this);}
function xx(){}
_=xx.prototype=new uv();_.p=Ay;_.eQ=By;_.E=Cy;_.hC=Dy;_.bb=Ey;_.tN=tC+'AbstractMap';_.tI=58;function bz(e,b){var a,c,d;if(b===e){return true;}if(!Cd(b,22)){return false;}c=Bd(b,22);if(c.Bb()!=e.Bb()){return false;}for(a=c.ab();a.F();){d=a.cb();if(!e.q(d)){return false;}}return true;}
function cz(a){return bz(this,a);}
function dz(){var a,b,c;a=0;for(b=this.ab();b.F();){c=b.cb();if(c!==null){a+=c.hC();}}return a;}
function Fy(){}
_=Fy.prototype=new cx();_.eQ=cz;_.hC=dz;_.tN=tC+'AbstractSet';_.tI=59;function zx(b,a,c){b.a=a;b.b=c;return b;}
function Bx(b){var a;a=vA(b.b);return ay(new Fx(),b,a);}
function Cx(a){return this.a.p(a);}
function Dx(){return Bx(this);}
function Ex(){return this.b.a.c;}
function yx(){}
_=yx.prototype=new Fy();_.q=Cx;_.ab=Dx;_.Bb=Ex;_.tN=tC+'AbstractMap$1';_.tI=60;function ay(b,a,c){b.a=c;return b;}
function cy(a){return nA(a.a);}
function dy(b){var a;a=oA(b.a);return a.z();}
function ey(){return cy(this);}
function fy(){return dy(this);}
function gy(){pA(this.a);}
function Fx(){}
_=Fx.prototype=new uv();_.F=ey;_.cb=fy;_.ub=gy;_.tN=tC+'AbstractMap$2';_.tI=0;function iy(b,a,c){b.a=a;b.b=c;return b;}
function ky(b){var a;a=vA(b.b);return py(new oy(),b,a);}
function ly(a){return EA(this.a,a);}
function my(){return ky(this);}
function ny(){return this.b.a.c;}
function hy(){}
_=hy.prototype=new cx();_.q=ly;_.ab=my;_.Bb=ny;_.tN=tC+'AbstractMap$3';_.tI=0;function py(b,a,c){b.a=c;return b;}
function ry(a){return nA(a.a);}
function sy(a){var b;b=oA(a.a).C();return b;}
function ty(){return ry(this);}
function uy(){return sy(this);}
function vy(){pA(this.a);}
function oy(){}
_=oy.prototype=new uv();_.F=ty;_.cb=uy;_.ub=vy;_.tN=tC+'AbstractMap$4';_.tI=0;function CA(){CA=fC;dB=jB();}
function zA(a){{BA(a);}}
function AA(a){CA();zA(a);return a;}
function BA(a){a.a=id();a.d=kd();a.b=ce(dB,ed);a.c=0;}
function DA(b,a){if(Cd(a,1)){return nB(b.d,Bd(a,1))!==dB;}else if(a===null){return b.b!==dB;}else{return mB(b.a,a,a.hC())!==dB;}}
function EA(a,b){if(a.b!==dB&&lB(a.b,b)){return true;}else if(iB(a.d,b)){return true;}else if(gB(a.a,b)){return true;}return false;}
function FA(a){return tA(new jA(),a);}
function aB(c,a){var b;if(Cd(a,1)){b=nB(c.d,Bd(a,1));}else if(a===null){b=c.b;}else{b=mB(c.a,a,a.hC());}return b===dB?null:b;}
function bB(c,a,d){var b;{b=c.b;c.b=d;}if(b===dB){++c.c;return null;}else{return b;}}
function cB(c,a){var b;if(Cd(a,1)){b=qB(c.d,Bd(a,1));}else if(a===null){b=c.b;c.b=ce(dB,ed);}else{b=pB(c.a,a,a.hC());}if(b===dB){return null;}else{--c.c;return b;}}
function eB(e,c){CA();for(var d in e){if(d==parseInt(d)){var a=e[d];for(var f=0,b=a.length;f<b;++f){c.n(a[f]);}}}}
function fB(d,a){CA();for(var c in d){if(c.charCodeAt(0)==58){var e=d[c];var b=eA(c.substring(1),e);a.n(b);}}}
function gB(f,h){CA();for(var e in f){if(e==parseInt(e)){var a=f[e];for(var g=0,b=a.length;g<b;++g){var c=a[g];var d=c.C();if(lB(h,d)){return true;}}}}return false;}
function hB(a){return DA(this,a);}
function iB(c,d){CA();for(var b in c){if(b.charCodeAt(0)==58){var a=c[b];if(lB(d,a)){return true;}}}return false;}
function jB(){CA();}
function kB(){return FA(this);}
function lB(a,b){CA();if(a===b){return true;}else if(a===null){return false;}else{return a.eQ(b);}}
function oB(a){return aB(this,a);}
function mB(f,h,e){CA();var a=f[e];if(a){for(var g=0,b=a.length;g<b;++g){var c=a[g];var d=c.z();if(lB(h,d)){return c.C();}}}}
function nB(b,a){CA();return b[':'+a];}
function pB(f,h,e){CA();var a=f[e];if(a){for(var g=0,b=a.length;g<b;++g){var c=a[g];var d=c.z();if(lB(h,d)){if(a.length==1){delete f[e];}else{a.splice(g,1);}return c.C();}}}}
function qB(c,a){CA();a=':'+a;var b=c[a];delete c[a];return b;}
function aA(){}
_=aA.prototype=new xx();_.p=hB;_.v=kB;_.E=oB;_.tN=tC+'HashMap';_.tI=61;_.a=null;_.b=null;_.c=0;_.d=null;var dB;function cA(b,a,c){b.a=a;b.b=c;return b;}
function eA(a,b){return cA(new bA(),a,b);}
function fA(b){var a;if(Cd(b,23)){a=Bd(b,23);if(lB(this.a,a.z())&&lB(this.b,a.C())){return true;}}return false;}
function gA(){return this.a;}
function hA(){return this.b;}
function iA(){var a,b;a=0;b=0;if(this.a!==null){a=this.a.hC();}if(this.b!==null){b=this.b.hC();}return a^b;}
function bA(){}
_=bA.prototype=new uv();_.eQ=fA;_.z=gA;_.C=hA;_.hC=iA;_.tN=tC+'HashMap$EntryImpl';_.tI=62;_.a=null;_.b=null;function tA(b,a){b.a=a;return b;}
function vA(a){return lA(new kA(),a.a);}
function wA(c){var a,b,d;if(Cd(c,23)){a=Bd(c,23);b=a.z();if(DA(this.a,b)){d=aB(this.a,b);return lB(a.C(),d);}}return false;}
function xA(){return vA(this);}
function yA(){return this.a.c;}
function jA(){}
_=jA.prototype=new Fy();_.q=wA;_.ab=xA;_.Bb=yA;_.tN=tC+'HashMap$EntrySet';_.tI=63;function lA(c,b){var a;c.c=b;a=gz(new ez());if(c.c.b!==(CA(),dB)){iz(a,cA(new bA(),null,c.c.b));}fB(c.c.d,a);eB(c.c.a,a);c.a=a.ab();return c;}
function nA(a){return a.a.F();}
function oA(a){return a.b=Bd(a.a.cb(),23);}
function pA(a){if(a.b===null){throw su(new ru(),'Must call next() before remove().');}else{a.a.ub();cB(a.c,a.b.z());a.b=null;}}
function qA(){return nA(this);}
function rA(){return oA(this);}
function sA(){pA(this);}
function kA(){}
_=kA.prototype=new uv();_.F=qA;_.cb=rA;_.ub=sA;_.tN=tC+'HashMap$EntrySetIterator';_.tI=0;_.a=null;_.b=null;function vB(){}
_=vB.prototype=new yv();_.tN=tC+'NoSuchElementException';_.tI=64;function AB(a){a.a=gz(new ez());return a;}
function BB(b,a){return iz(b.a,a);}
function DB(a){return a.a.ab();}
function EB(a,b){hz(this.a,a,b);}
function FB(a){return BB(this,a);}
function aC(a){return mz(this.a,a);}
function bC(a){return nz(this.a,a);}
function cC(){return DB(this);}
function dC(a){return rz(this.a,a);}
function eC(){return this.a.b;}
function zB(){}
_=zB.prototype=new hx();_.m=EB;_.n=FB;_.q=aC;_.D=bC;_.ab=cC;_.vb=dC;_.Bb=eC;_.tN=tC+'Vector';_.tI=65;_.a=null;function Ft(){vb(new ab());}
function gwtOnLoad(b,d,c){$moduleName=d;$moduleBase=c;if(b)try{Ft();}catch(a){b(d);}else{Ft();}}
var be=[{},{},{1:1},{3:1},{11:1},{7:1},{12:1},{14:1},{14:1},{13:1},{5:1},{5:1},{5:1},{5:1},{6:1},{5:1},{9:1},{9:1},{9:1},{6:1,8:1},{6:1},{10:1},{5:1},{5:1},{4:1,5:1},{5:1},{16:1,17:1,18:1,19:1},{16:1,17:1,18:1,19:1},{16:1,17:1,18:1,19:1},{16:1,17:1,18:1,19:1},{16:1,17:1,18:1,19:1},{16:1,17:1,18:1,19:1},{16:1,17:1,18:1,19:1},{16:1,17:1,18:1,19:1},{2:1},{2:1},{2:1},{2:1},{16:1,17:1,18:1,19:1},{16:1,17:1,18:1,19:1},{16:1,17:1,18:1,19:1},{2:1},{16:1,17:1,18:1,19:1},{15:1,16:1,17:1,18:1,19:1},{10:1},{16:1,17:1,18:1,19:1},{16:1,17:1,18:1,19:1},{16:1,17:1,18:1,19:1},{5:1},{5:1},{5:1},{5:1},{5:1},{20:1},{5:1},{5:1},{5:1},{5:1},{21:1},{22:1},{22:1},{21:1},{23:1},{22:1},{5:1},{2:1}];if (TFDSSummarizer) {  var __gwt_initHandlers = TFDSSummarizer.__gwt_initHandlers;  TFDSSummarizer.onScriptLoad(gwtOnLoad);}})();