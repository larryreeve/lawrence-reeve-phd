(function(){var $wnd = window;var $doc = $wnd.document;var $moduleName, $moduleBase;var _,bC='client.',cC='client.service.',dC='com.google.gwt.core.client.',eC='com.google.gwt.lang.',fC='com.google.gwt.user.client.',gC='com.google.gwt.user.client.impl.',hC='com.google.gwt.user.client.rpc.',iC='com.google.gwt.user.client.rpc.core.java.lang.',jC='com.google.gwt.user.client.rpc.core.java.util.',kC='com.google.gwt.user.client.rpc.impl.',lC='com.google.gwt.user.client.ui.',mC='com.google.gwt.user.client.ui.impl.',nC='java.lang.',oC='java.util.';function aC(){}
function rv(a){return this===a;}
function sv(){return vw(this);}
function pv(){}
_=pv.prototype={};_.eQ=rv;_.hC=sv;_.tN=nC+'Object';_.tI=1;function s(){}
_=s.prototype=new pv();_.tN=bC+'Sentence';_.tI=3;_.a=0.0;_.b=0;_.c=0;_.d='';function w(b,a){C(a,b.qb());D(a,b.rb());E(a,b.rb());F(a,b.tb());}
function x(a){return a.a;}
function y(a){return a.b;}
function z(a){return a.c;}
function A(a){return a.d;}
function B(b,a){b.Cb(x(a));b.Db(y(a));b.Db(z(a));b.Fb(A(a));}
function C(a,b){a.a=b;}
function D(a,b){a.b=b;}
function E(a,b){a.c=b;}
function F(a,b){a.d=b;}
function vb(r){var a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q;c=xp(new vp(),'Input text to be summarized:');g=lr(new kr());nr(g,80);or(g,25);a=bn(new Bm(),'Summarize');o=xp(new vp(),'Summary Size (% of original):');p=bq(new Bp());for(b=1;b<=100;b++)dq(p,zu(b));mq(p,false);nq(p,1);lq(p,9,true);d=bp(new Fo());cp(d,a);cp(d,o);cp(d,p);kn(d,o,(to(),vo));kn(d,p,(to(),vo));ds(d,'95%');e=ls(new js());ms(e,c);ms(e,g);ms(e,d);j=xp(new vp(),'System-generated Summary:');l=lr(new kr());nr(l,80);or(l,25);vr(l,true);n=jo(new io());k=ls(new js());ms(k,j);ms(k,l);ms(k,n);f=ko(new io(),'<br><br><br>This summarizer implements the frequency distribution summarization algorithm (using terms rather than concepts) described in these papers:<br><br>Lawrence H. Reeve, Hyoil Han, Saya V. Nagori, Jonathan C. Yang, Tamara A. Schwimmer, and Ari D. Brooks (2006).<br><EM><A href="http://cluster.cis.drexel.edu:8080/biotus/pubs/2006CIKM.pdf">Concept Frequency Distribution in Biomedical Text Summarization<\/A>.<\/EM><br><A href="http://sa1.sice.umkc.edu/cikm2006/"> <FONT face="Times New Roman">Proceedings of the 15th Conference on Information and Knowledge Management<\/FONT><\/A><FONT face="Times New Roman"><\/FONT><A href="http://www.cs.iupui.edu/%7Ebioin/"><\/A>.<br><br>Lawrence H. Reeve and Hyoil Han (2007).<br><EM><a href="http://cluster.cis.drexel.edu:8080/biotus/pubs/2007DUC.pdf">A Term Frequency Distribution Approach for the DUC-2007 Update Task.<\/a><\/EM><br>Proceedings of the 2007 Document Understanding Conference Workshop (DUC 2007)<br><br>');m=bp(new Fo());cp(m,f);h=bp(new Fo());cp(h,e);cp(h,k);Eh(r);xm(ar(),h);xm(ar(),m);r.b=Eb(new yb());q=r.b;i=xc()+'summarizerservice';bc(q,i);r.a=cb(new bb(),r,l,n,a);zg(new gb());ei(),di();rr(g,new jb());sr(g,nb(new mb(),r,l));a.k(rb(new qb(),r,a,l,n,g,p));}
function wb(b,a){}
function ab(){}
_=ab.prototype=new pv();_.pb=wb;_.tN=bC+'TFDSSummarizer';_.tI=4;_.a=null;_.b=null;function cb(b,a,d,e,c){b.b=d;b.c=e;b.a=c;return b;}
function eb(b,a){mo(b.c,'Server Response:\n\n'+a.a);eo(b.a,true);}
function fb(g,c){var a,b,d,e,f;f=Bd(c,2);b=zv(new yv());for(a=0;a<f.Bb();a++){d=Bd(f.D(a),3);if(d.c==0){e=d.d;if(e!==null&&gw(e)!=0){Bv(b,d.d);Bv(b,'\n\n');}}else{Bv(b,'['+d.c+']: '+d.d);Bv(b,'\n\n');}}wr(g.b,Fv(b));zp(g.c,'');eo(g.a,true);}
function bb(){}
_=bb.prototype=new pv();_.tN=bC+'TFDSSummarizer$1';_.tI=0;function ib(){ei(),di();}
function gb(){}
_=gb.prototype=new pv();_.w=ib;_.tN=bC+'TFDSSummarizer$2';_.tI=5;function lb(a){}
function jb(){}
_=jb.prototype=new pv();_.fb=lb;_.tN=bC+'TFDSSummarizer$3';_.tI=6;function jp(c,a,b){}
function kp(c,a,b){}
function lp(c,a,b){}
function hp(){}
_=hp.prototype=new pv();_.ib=jp;_.jb=kp;_.kb=lp;_.tN=lC+'KeyboardListenerAdapter';_.tI=7;function nb(b,a,c){b.a=c;return b;}
function pb(d,a,b){var c;c=ur(this.a);if(c!==null&&gw(c)>0)wr(this.a,'');}
function mb(){}
_=mb.prototype=new hp();_.jb=pb;_.tN=bC+'TFDSSummarizer$4';_.tI=8;function rb(b,a,c,e,f,d,g){b.a=a;b.b=c;b.d=e;b.e=f;b.c=d;b.f=g;return b;}
function tb(a){eo(this.b,false);wr(this.d,'');mo(this.e,'<b><i>Please wait...summarizing the source text.<\/i><\/b>');cc(this.a.b,ur(this.c),Au(iq(this.f,hq(this.f))),this.a.a);}
function qb(){}
_=qb.prototype=new pv();_.gb=tb;_.tN=bC+'TFDSSummarizer$5';_.tI=9;function ac(){ac=aC;dc=fc(new ec());}
function Eb(a){ac();return a;}
function Fb(d,b,c,a){if(d.a===null)throw hk(new gk());gm(b);jl(b,'client.service.ISummarizerService');jl(b,'summarizeTFDS');hl(b,2);jl(b,'java.lang.String');jl(b,'java.lang.Integer');jl(b,c);il(b,a);}
function bc(b,a){b.a=a;}
function cc(j,i,f,c){var a,d,e,g,h;g=tl(new sl(),dc);h=cm(new am(),dc,xc(),'AF8D9E63B5457AB80016BBD0E4B3C585');try{Fb(j,h,i,f);}catch(a){a=fe(a);if(Cd(a,4)){d=a;eb(c,d);return;}else throw a;}e=Ab(new zb(),j,g,c);if(!gh(j.a,jm(h),e))eb(c,Ej(new Dj(),'Unable to initiate the asynchronous service invocation -- check the network connection'));}
function yb(){}
_=yb.prototype=new pv();_.tN=cC+'ISummarizerService_Proxy';_.tI=0;_.a=null;var dc;function Ab(b,a,d,c){b.b=d;b.a=c;return b;}
function Cb(g,e){var a,c,d,f;f=null;c=null;try{if(hw(e,'//OK')){wl(g.b,iw(e,4));f=cl(g.b);}else if(hw(e,'//EX')){wl(g.b,iw(e,4));c=Bd(cl(g.b),5);}else{c=Ej(new Dj(),e);}}catch(a){a=fe(a);if(Cd(a,4)){a;c=xj(new wj());}else if(Cd(a,5)){d=a;c=d;}else throw a;}if(c===null)fb(g.a,f);else eb(g.a,c);}
function Db(a){var b;b=zc;Cb(this,a);}
function zb(){}
_=zb.prototype=new pv();_.hb=Db;_.tN=cC+'ISummarizerService_Proxy$1';_.tI=0;function gc(){gc=aC;rc=lc();tc=mc();}
function fc(a){gc();return a;}
function hc(d,c,a,e){var b=rc[e];if(!b){sc(e);}b[1](c,a);}
function ic(b,c){var a=tc[c];return a==null?c:a;}
function jc(c,b,d){var a=rc[d];if(!a){sc(d);}return a[0](b);}
function kc(d,c,a,e){var b=rc[e];if(!b){sc(e);}b[2](c,a);}
function lc(){gc();return {'client.Sentence/1365443775':[function(a){return nc(a);},function(a,b){w(a,b);},function(a,b){B(a,b);}],'com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException/3936916533':[function(a){return oc(a);},function(a,b){Bj(a,b);},function(a,b){Cj(a,b);}],'java.lang.Integer/3438268394':[function(a){return nk(a);},function(a,b){mk(a,b);},function(a,b){ok(a,b);}],'java.lang.String/2004016611':[function(a){return sk(a);},function(a,b){rk(a,b);},function(a,b){tk(a,b);}],'java.util.ArrayList/3821976829':[function(a){return pc(a);},function(a,b){wk(a,b);},function(a,b){xk(a,b);}],'java.util.Vector/3125574444':[function(a){return qc(a);},function(a,b){Ak(a,b);},function(a,b){Bk(a,b);}]};}
function mc(){gc();return {'client.Sentence':'1365443775','com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException':'3936916533','java.lang.Integer':'3438268394','java.lang.String':'2004016611','java.util.ArrayList':'3821976829','java.util.Vector':'3125574444'};}
function nc(a){gc();return new s();}
function oc(a){gc();return xj(new wj());}
function pc(a){gc();return bz(new Fy());}
function qc(a){gc();return vB(new uB());}
function sc(a){gc();throw ck(new bk(),a);}
function ec(){}
_=ec.prototype=new pv();_.tN=cC+'ISummarizerService_TypeSerializer';_.tI=0;var rc,tc;function xc(){return Ec();}
function yc(a){return a==null?null:a.tN;}
var zc=null;function Cc(a){return a==null?0:a.$H?a.$H:(a.$H=Fc());}
function Dc(a){return a==null?0:a.$H?a.$H:(a.$H=Fc());}
function Ec(){return $moduleBase;}
function Fc(){return ++ad;}
var ad=0;function xw(b,a){b.a=a;return b;}
function yw(c,b,a){c.a=b;return c;}
function ww(){}
_=ww.prototype=new pv();_.tN=nC+'Throwable';_.tI=10;_.a=null;function gu(b,a){xw(b,a);return b;}
function hu(c,b,a){yw(c,b,a);return c;}
function fu(){}
_=fu.prototype=new ww();_.tN=nC+'Exception';_.tI=11;function uv(b,a){gu(b,a);return b;}
function vv(c,b,a){hu(c,b,a);return c;}
function tv(){}
_=tv.prototype=new fu();_.tN=nC+'RuntimeException';_.tI=12;function cd(c,b,a){uv(c,'JavaScript '+b+' exception: '+a);return c;}
function bd(){}
_=bd.prototype=new tv();_.tN=dC+'JavaScriptException';_.tI=13;function gd(b,a){if(!Cd(a,6)){return false;}return ld(b,Bd(a,6));}
function hd(a){return Cc(a);}
function id(){return [];}
function jd(){return function(){};}
function kd(){return {};}
function md(a){return gd(this,a);}
function ld(a,b){return a===b;}
function nd(){return hd(this);}
function ed(){}
_=ed.prototype=new pv();_.eQ=md;_.hC=nd;_.tN=dC+'JavaScriptObject';_.tI=14;function pd(c,a,d,b,e){c.a=a;c.b=b;c.tN=e;c.tI=d;return c;}
function rd(a,b,c){return a[b]=c;}
function sd(b,a){return b[a];}
function td(a){return a.length;}
function vd(e,d,c,b,a){return ud(e,d,c,b,0,td(b),a);}
function ud(j,i,g,c,e,a,b){var d,f,h;if((f=sd(c,e))<0){throw new Fu();}h=pd(new od(),f,sd(i,e),sd(g,e),j);++e;if(e<a){j=iw(j,1);for(d=0;d<f;++d){rd(h,d,ud(j,i,g,c,e,a,b));}}else{for(d=0;d<f;++d){rd(h,d,b);}}return h;}
function wd(a,b,c){if(c!==null&&a.b!=0&& !Cd(c,a.b)){throw new Bt();}return rd(a,b,c);}
function od(){}
_=od.prototype=new pv();_.tN=eC+'Array';_.tI=0;function zd(b,a){return !(!(b&&be[b][a]));}
function Ad(a){return String.fromCharCode(a);}
function Bd(b,a){if(b!=null)zd(b.tI,a)||ae();return b;}
function Cd(b,a){return b!=null&&zd(b.tI,a);}
function Dd(a){return a&65535;}
function Ed(a){return ~(~a);}
function ae(){throw new bu();}
function Fd(a){if(a!==null){throw new bu();}return a;}
function ce(b,d){_=d.prototype;if(b&& !(b.tI>=_.tI)){var c=b.toString;for(var a in _){b[a]=_[a];}b.toString=c;}return b;}
var be;function fe(a){if(Cd(a,5)){return a;}return cd(new bd(),he(a),ge(a));}
function ge(a){return a.message;}
function he(a){return a.name;}
function je(b,a){return b;}
function ie(){}
_=ie.prototype=new tv();_.tN=fC+'CommandCanceledException';_.tI=15;function af(a){a.a=ne(new me(),a);a.b=bz(new Fy());a.d=re(new qe(),a);a.f=ve(new ue(),a);}
function bf(a){af(a);return a;}
function df(c){var a,b,d;a=xe(c.f);Ae(c.f);b=null;if(Cd(a,7)){b=je(new ie(),Bd(a,7));}else{}if(b!==null){d=zc;}gf(c,false);ff(c);}
function ef(e,d){var a,b,c,f;f=false;try{gf(e,true);Be(e.f,e.b.b);sh(e.a,10000);while(ye(e.f)){b=ze(e.f);c=true;try{if(b===null){return;}if(Cd(b,7)){a=Bd(b,7);a.w();}else{}}finally{f=Ce(e.f);if(f){return;}if(c){Ae(e.f);}}if(kf(uw(),d)){return;}}}finally{if(!f){ph(e.a);gf(e,false);ff(e);}}}
function ff(a){if(!lz(a.b)&& !a.e&& !a.c){hf(a,true);sh(a.d,1);}}
function gf(b,a){b.c=a;}
function hf(b,a){b.e=a;}
function jf(b,a){dz(b.b,a);ff(b);}
function kf(a,b){return Du(a-b)>=100;}
function le(){}
_=le.prototype=new pv();_.tN=fC+'CommandExecutor';_.tI=0;_.c=false;_.e=false;function qh(){qh=aC;yh=bz(new Fy());{xh();}}
function oh(a){qh();return a;}
function ph(a){if(a.b){th(a.c);}else{uh(a.c);}nz(yh,a);}
function rh(a){if(!a.b){nz(yh,a);}a.xb();}
function sh(b,a){if(a<=0){throw ku(new ju(),'must be positive');}ph(b);b.b=false;b.c=vh(b,a);dz(yh,b);}
function th(a){qh();$wnd.clearInterval(a);}
function uh(a){qh();$wnd.clearTimeout(a);}
function vh(b,a){qh();return $wnd.setTimeout(function(){b.x();},a);}
function wh(){var a;a=zc;{rh(this);}}
function xh(){qh();Dh(new kh());}
function jh(){}
_=jh.prototype=new pv();_.x=wh;_.tN=fC+'Timer';_.tI=16;_.b=false;_.c=0;var yh;function oe(){oe=aC;qh();}
function ne(b,a){oe();b.a=a;oh(b);return b;}
function pe(){if(!this.a.c){return;}df(this.a);}
function me(){}
_=me.prototype=new jh();_.xb=pe;_.tN=fC+'CommandExecutor$1';_.tI=17;function se(){se=aC;qh();}
function re(b,a){se();b.a=a;oh(b);return b;}
function te(){hf(this.a,false);ef(this.a,uw());}
function qe(){}
_=qe.prototype=new jh();_.xb=te;_.tN=fC+'CommandExecutor$2';_.tI=18;function ve(b,a){b.d=a;return b;}
function xe(a){return iz(a.d.b,a.b);}
function ye(a){return a.c<a.a;}
function ze(b){var a;b.b=b.c;a=iz(b.d.b,b.c++);if(b.c>=b.a){b.c=0;}return a;}
function Ae(a){mz(a.d.b,a.b);--a.a;if(a.b<=a.c){if(--a.c<0){a.c=0;}}a.b=(-1);}
function Be(b,a){b.a=a;}
function Ce(a){return a.b==(-1);}
function De(){return ye(this);}
function Ee(){return ze(this);}
function Fe(){Ae(this);}
function ue(){}
_=ue.prototype=new pv();_.F=De;_.cb=Ee;_.ub=Fe;_.tN=fC+'CommandExecutor$CircularIterator';_.tI=0;_.a=0;_.b=(-1);_.c=0;function nf(){nf=aC;mg=bz(new Fy());{hg=new li();si(hg);}}
function of(b,a){nf();ui(hg,b,a);}
function pf(a,b){nf();return pi(hg,a,b);}
function qf(){nf();return wi(hg,'button');}
function rf(){nf();return wi(hg,'div');}
function sf(a){nf();return xi(hg,a);}
function tf(){nf();return wi(hg,'tbody');}
function uf(){nf();return wi(hg,'td');}
function vf(){nf();return wi(hg,'tr');}
function wf(){nf();return wi(hg,'table');}
function xf(){nf();return wi(hg,'textarea');}
function Af(b,a,d){nf();var c;c=zc;{zf(b,a,d);}}
function zf(b,a,c){nf();var d;if(a===lg){if(bg(b)==8192){lg=null;}}d=yf;yf=b;try{c.eb(b);}finally{yf=d;}}
function Bf(b,a){nf();yi(hg,b,a);}
function Cf(a){nf();return zi(hg,a);}
function Df(a){nf();return Ai(hg,a);}
function Ef(a){nf();return Bi(hg,a);}
function Ff(a){nf();return Ci(hg,a);}
function ag(a){nf();return Di(hg,a);}
function bg(a){nf();return Ei(hg,a);}
function cg(a){nf();qi(hg,a);}
function eg(a,b){nf();return aj(hg,a,b);}
function dg(a,b){nf();return Fi(hg,a,b);}
function fg(a){nf();return bj(hg,a);}
function gg(a){nf();return ri(hg,a);}
function ig(c,b,d,a){nf();cj(hg,c,b,d,a);}
function jg(a){nf();var b,c;c=true;if(mg.b>0){b=Fd(iz(mg,mg.b-1));if(!(c=null.bc())){Bf(a,true);cg(a);}}return c;}
function kg(b,a){nf();dj(hg,b,a);}
function pg(a,b,c){nf();gj(hg,a,b,c);}
function ng(a,b,c){nf();ej(hg,a,b,c);}
function og(a,b,c){nf();fj(hg,a,b,c);}
function qg(a,b){nf();hj(hg,a,b);}
function rg(a,b){nf();ij(hg,a,b);}
function sg(a,b){nf();jj(hg,a,b);}
function tg(b,a,c){nf();kj(hg,b,a,c);}
function ug(a,b){nf();ti(hg,a,b);}
function vg(){nf();return lj(hg);}
function wg(){nf();return mj(hg);}
var yf=null,hg=null,lg=null,mg;function yg(){yg=aC;Ag=bf(new le());}
function zg(a){yg();if(a===null){throw cv(new bv(),'cmd can not be null');}jf(Ag,a);}
var Ag;function Dg(a){if(Cd(a,8)){return pf(this,Bd(a,8));}return gd(ce(this,Bg),a);}
function Eg(){return hd(ce(this,Bg));}
function Bg(){}
_=Bg.prototype=new ed();_.eQ=Dg;_.hC=Eg;_.tN=fC+'Element';_.tI=19;function ch(a){return gd(ce(this,Fg),a);}
function dh(){return hd(ce(this,Fg));}
function Fg(){}
_=Fg.prototype=new ed();_.eQ=ch;_.hC=dh;_.tN=fC+'Event';_.tI=20;function fh(){fh=aC;hh=oj(new nj());}
function gh(c,b,a){fh();return qj(hh,c,b,a);}
var hh;function mh(){while((qh(),yh).b>0){ph(Bd(iz((qh(),yh),0),9));}}
function nh(){return null;}
function kh(){}
_=kh.prototype=new pv();_.nb=mh;_.ob=nh;_.tN=fC+'Timer$1';_.tI=21;function Ch(){Ch=aC;Fh=bz(new Fy());ji=bz(new Fy());{fi();}}
function Dh(a){Ch();dz(Fh,a);}
function Eh(a){Ch();dz(ji,a);}
function ai(){Ch();var a,b;for(a=Fh.ab();a.F();){b=Bd(a.cb(),10);b.nb();}}
function bi(){Ch();var a,b,c,d;d=null;for(a=Fh.ab();a.F();){b=Bd(a.cb(),10);c=b.ob();{d=c;}}return d;}
function ci(){Ch();var a,b;for(a=ji.ab();a.F();){b=Bd(a.cb(),11);b.pb(ei(),di());}}
function di(){Ch();return vg();}
function ei(){Ch();return wg();}
function fi(){Ch();__gwt_initHandlers(function(){ii();},function(){return hi();},function(){gi();$wnd.onresize=null;$wnd.onbeforeclose=null;$wnd.onclose=null;});}
function gi(){Ch();var a;a=zc;{ai();}}
function hi(){Ch();var a;a=zc;{return bi();}}
function ii(){Ch();var a;a=zc;{ci();}}
var Fh,ji;function ui(c,b,a){b.appendChild(a);}
function wi(b,a){return $doc.createElement(a);}
function xi(c,a){var b;b=wi(c,'select');if(a){ej(c,b,'multiple',true);}return b;}
function yi(c,b,a){b.cancelBubble=a;}
function zi(b,a){return !(!a.altKey);}
function Ai(b,a){return !(!a.ctrlKey);}
function Bi(b,a){return a.which||(a.keyCode|| -1);}
function Ci(b,a){return !(!a.metaKey);}
function Di(b,a){return !(!a.shiftKey);}
function Ei(b,a){switch(a.type){case 'blur':return 4096;case 'change':return 1024;case 'click':return 1;case 'dblclick':return 2;case 'focus':return 2048;case 'keydown':return 128;case 'keypress':return 256;case 'keyup':return 512;case 'load':return 32768;case 'losecapture':return 8192;case 'mousedown':return 4;case 'mousemove':return 64;case 'mouseout':return 32;case 'mouseover':return 16;case 'mouseup':return 8;case 'scroll':return 16384;case 'error':return 65536;case 'mousewheel':return 131072;case 'DOMMouseScroll':return 131072;}}
function aj(d,a,b){var c=a[b];return c==null?null:String(c);}
function Fi(d,a,c){var b=parseInt(a[c]);if(!b){return 0;}return b;}
function bj(b,a){return a.__eventBits||0;}
function cj(e,d,b,f,a){var c=new Option(b,f);if(a== -1||a>d.options.length-1){d.add(c,null);}else{d.add(c,d.options[a]);}}
function dj(c,b,a){b.removeChild(a);}
function gj(c,a,b,d){a[b]=d;}
function ej(c,a,b,d){a[b]=d;}
function fj(c,a,b,d){a[b]=d;}
function hj(c,a,b){a.__listener=b;}
function ij(c,a,b){if(!b){b='';}a.innerHTML=b;}
function jj(c,a,b){while(a.firstChild){a.removeChild(a.firstChild);}if(b!=null){a.appendChild($doc.createTextNode(b));}}
function kj(c,b,a,d){b.style[a]=d;}
function lj(a){return $doc.body.clientHeight;}
function mj(a){return $doc.body.clientWidth;}
function ki(){}
_=ki.prototype=new pv();_.tN=gC+'DOMImpl';_.tI=0;function pi(c,a,b){return a==b;}
function qi(b,a){a.preventDefault();}
function ri(c,a){var b=a.parentNode;if(b==null){return null;}if(b.nodeType!=1)b=null;return b||null;}
function si(d){$wnd.__dispatchCapturedMouseEvent=function(b){if($wnd.__dispatchCapturedEvent(b)){var a=$wnd.__captureElem;if(a&&a.__listener){Af(b,a,a.__listener);b.stopPropagation();}}};$wnd.__dispatchCapturedEvent=function(a){if(!jg(a)){a.stopPropagation();a.preventDefault();return false;}return true;};$wnd.addEventListener('click',$wnd.__dispatchCapturedMouseEvent,true);$wnd.addEventListener('dblclick',$wnd.__dispatchCapturedMouseEvent,true);$wnd.addEventListener('mousedown',$wnd.__dispatchCapturedMouseEvent,true);$wnd.addEventListener('mouseup',$wnd.__dispatchCapturedMouseEvent,true);$wnd.addEventListener('mousemove',$wnd.__dispatchCapturedMouseEvent,true);$wnd.addEventListener('mousewheel',$wnd.__dispatchCapturedMouseEvent,true);$wnd.addEventListener('keydown',$wnd.__dispatchCapturedEvent,true);$wnd.addEventListener('keyup',$wnd.__dispatchCapturedEvent,true);$wnd.addEventListener('keypress',$wnd.__dispatchCapturedEvent,true);$wnd.__dispatchEvent=function(b){var c,a=this;while(a&& !(c=a.__listener))a=a.parentNode;if(a&&a.nodeType!=1)a=null;if(c)Af(b,a,c);};$wnd.__captureElem=null;}
function ti(c,b,a){b.__eventBits=a;b.onclick=a&1?$wnd.__dispatchEvent:null;b.ondblclick=a&2?$wnd.__dispatchEvent:null;b.onmousedown=a&4?$wnd.__dispatchEvent:null;b.onmouseup=a&8?$wnd.__dispatchEvent:null;b.onmouseover=a&16?$wnd.__dispatchEvent:null;b.onmouseout=a&32?$wnd.__dispatchEvent:null;b.onmousemove=a&64?$wnd.__dispatchEvent:null;b.onkeydown=a&128?$wnd.__dispatchEvent:null;b.onkeypress=a&256?$wnd.__dispatchEvent:null;b.onkeyup=a&512?$wnd.__dispatchEvent:null;b.onchange=a&1024?$wnd.__dispatchEvent:null;b.onfocus=a&2048?$wnd.__dispatchEvent:null;b.onblur=a&4096?$wnd.__dispatchEvent:null;b.onlosecapture=a&8192?$wnd.__dispatchEvent:null;b.onscroll=a&16384?$wnd.__dispatchEvent:null;b.onload=a&32768?$wnd.__dispatchEvent:null;b.onerror=a&65536?$wnd.__dispatchEvent:null;b.onmousewheel=a&131072?$wnd.__dispatchEvent:null;}
function ni(){}
_=ni.prototype=new ki();_.tN=gC+'DOMImplStandard';_.tI=0;function li(){}
_=li.prototype=new ni();_.tN=gC+'DOMImplOpera';_.tI=0;function oj(a){uj=jd();return a;}
function qj(c,d,b,a){return rj(c,null,null,d,b,a);}
function rj(d,f,c,e,b,a){return pj(d,f,c,e,b,a);}
function pj(e,g,d,f,c,b){var h=e.t();try{h.open('POST',f,true);h.setRequestHeader('Content-Type','text/plain; charset=utf-8');h.onreadystatechange=function(){if(h.readyState==4){h.onreadystatechange=uj;b.hb(h.responseText||'');}};h.send(c);return true;}catch(a){h.onreadystatechange=uj;return false;}}
function tj(){return new XMLHttpRequest();}
function nj(){}
_=nj.prototype=new pv();_.t=tj;_.tN=gC+'HTTPRequestImpl';_.tI=0;var uj=null;function xj(a){uv(a,'This application is out of date, please click the refresh button on your browser');return a;}
function wj(){}
_=wj.prototype=new tv();_.tN=hC+'IncompatibleRemoteServiceException';_.tI=22;function Bj(b,a){}
function Cj(b,a){}
function Ej(b,a){vv(b,a,null);return b;}
function Dj(){}
_=Dj.prototype=new tv();_.tN=hC+'InvocationException';_.tI=23;function ck(b,a){gu(b,a);return b;}
function bk(){}
_=bk.prototype=new fu();_.tN=hC+'SerializationException';_.tI=24;function hk(a){Ej(a,'Service implementation URL not specified');return a;}
function gk(){}
_=gk.prototype=new Dj();_.tN=hC+'ServiceDefTarget$NoServiceEntryPointSpecifiedException';_.tI=25;function mk(b,a){}
function nk(a){return tu(new su(),a.rb());}
function ok(b,a){b.Db(a.a);}
function rk(b,a){}
function sk(a){return a.tb();}
function tk(b,a){b.Fb(a);}
function wk(e,b){var a,c,d;d=e.rb();for(a=0;a<d;++a){c=e.sb();dz(b,c);}}
function xk(e,a){var b,c,d;d=a.b;e.Db(d);b=a.ab();while(b.F()){c=b.cb();e.Eb(c);}}
function Ak(e,b){var a,c,d;d=e.rb();for(a=0;a<d;++a){c=e.sb();wB(b,c);}}
function Bk(e,a){var b,c,d;d=a.a.b;e.Db(d);b=yB(a);while(b.F()){c=b.cb();e.Eb(c);}}
function pl(a){return a.j>2;}
function ql(b,a){b.i=a;}
function rl(a,b){a.j=b;}
function Ck(){}
_=Ck.prototype=new pv();_.tN=kC+'AbstractSerializationStream';_.tI=0;_.i=0;_.j=3;function Ek(a){a.e=bz(new Fy());}
function Fk(a){Ek(a);return a;}
function bl(b,a){fz(b.e);rl(b,xl(b));ql(b,xl(b));}
function cl(a){var b,c;b=a.rb();if(b<0){return iz(a.e,-(b+1));}c=a.B(b);if(c===null){return null;}return a.r(c);}
function dl(b,a){dz(b.e,a);}
function el(){return cl(this);}
function Dk(){}
_=Dk.prototype=new Ck();_.sb=el;_.tN=kC+'AbstractSerializationStreamReader';_.tI=0;function hl(b,a){b.o(rw(a));}
function il(c,a){var b,d;if(a===null){jl(c,null);return;}b=c.y(a);if(b>=0){hl(c,-(b+1));return;}c.yb(a);d=c.A(a);jl(c,d);c.zb(a,d);}
function jl(a,b){hl(a,a.l(b));}
function kl(a){this.o(qw(a));}
function ll(a){hl(this,a);}
function ml(a){il(this,a);}
function nl(a){jl(this,a);}
function fl(){}
_=fl.prototype=new Ck();_.Cb=kl;_.Db=ll;_.Eb=ml;_.Fb=nl;_.tN=kC+'AbstractSerializationStreamWriter';_.tI=0;function tl(b,a){Fk(b);b.c=a;return b;}
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
_=sl.prototype=new Dk();_.r=zl;_.B=Cl;_.qb=Dl;_.rb=El;_.tb=Fl;_.tN=kC+'ClientSerializationStreamReader';_.tI=0;_.a=0;_.b=null;_.c=null;_.d=null;function bm(a){a.h=bz(new Fy());}
function cm(d,c,a,b){bm(d);d.f=c;d.b=a;d.e=b;return d;}
function em(c,a){var b=c.d[a];return b==null?-1:b;}
function fm(c,a){var b=c.g[':'+a];return b==null?0:b;}
function gm(a){a.c=0;a.d=kd();a.g=kd();fz(a.h);a.a=zv(new yv());if(pl(a)){jl(a,a.b);jl(a,a.e);}}
function hm(b,a,c){b.d[a]=c;}
function im(b,a,c){b.g[':'+a]=c;}
function jm(b){var a;a=zv(new yv());km(b,a);mm(b,a);lm(b,a);return Fv(a);}
function km(b,a){om(a,rw(b.j));om(a,rw(b.i));}
function lm(b,a){Bv(a,Fv(b.a));}
function mm(d,a){var b,c;c=d.h.b;om(a,rw(c));for(b=0;b<c;++b){om(a,Bd(iz(d.h,b),1));}return a;}
function nm(b){var a;if(b===null){return 0;}a=fm(this,b);if(a>0){return a;}dz(this.h,b);a=this.h.b;im(this,b,a);return a;}
function om(a,b){Bv(a,b);Av(a,65535);}
function pm(a){om(this.a,a);}
function qm(a){return em(this,vw(a));}
function rm(a){var b,c;c=yc(a);b=ic(this.f,c);if(b!==null){c+='/'+b;}return c;}
function sm(a){hm(this,vw(a),this.c++);}
function tm(a,b){kc(this.f,this,a,b);}
function am(){}
_=am.prototype=new fl();_.l=nm;_.o=pm;_.y=qm;_.A=rm;_.yb=sm;_.zb=tm;_.tN=kC+'ClientSerializationStreamWriter';_.tI=0;_.a=null;_.b=null;_.c=0;_.d=null;_.e=null;_.f=null;_.g=null;function Ar(b,a){Br(b,Dr(b)+Ad(45)+a);}
function Br(b,a){is(b.i,a,true);}
function Dr(a){return gs(a.i);}
function Er(b,a){Fr(b,Dr(b)+Ad(45)+a);}
function Fr(b,a){is(b.i,a,false);}
function as(d,b,a){var c=b.parentNode;if(!c){return;}c.insertBefore(a,b);c.removeChild(b);}
function bs(b,a){if(b.i!==null){as(b,b.i,a);}b.i=a;}
function cs(b,a){hs(b.i,a);}
function ds(a,b){tg(a.i,'width',b);}
function es(b,a){ug(b.i,a|fg(b.i));}
function fs(a){return eg(a,'className');}
function gs(a){var b,c;b=fs(a);c=dw(b,32);if(c>=0){return jw(b,0,c);}return b;}
function hs(a,b){pg(a,'className',b);}
function is(c,j,a){var b,d,e,f,g,h,i;if(c===null){throw uv(new tv(),'Null widget handle. If you are creating a composite, ensure that initWidget() has been called.');}j=kw(j);if(gw(j)==0){throw ku(new ju(),'Style names cannot be empty');}i=fs(c);e=ew(i,j);while(e!=(-1)){if(e==0||bw(i,e-1)==32){f=e+gw(j);g=gw(i);if(f==g||f<g&&bw(i,f)==32){break;}}e=fw(i,j,e+1);}if(a){if(e==(-1)){if(gw(i)>0){i+=' ';}pg(c,'className',i+j);}}else{if(e!=(-1)){b=kw(jw(i,0,e));d=kw(iw(i,e+gw(j)));if(gw(b)==0){h=d;}else if(gw(d)==0){h=b;}else{h=b+' '+d;}pg(c,'className',h);}}}
function zr(){}
_=zr.prototype=new pv();_.tN=lC+'UIObject';_.tI=0;_.i=null;function dt(a){if(a.g){throw nu(new mu(),"Should only call onAttach when the widget is detached from the browser's document");}a.g=true;qg(a.i,a);a.s();a.lb();}
function et(a){if(!a.g){throw nu(new mu(),"Should only call onDetach when the widget is attached to the browser's document");}try{a.mb();}finally{a.u();qg(a.i,null);a.g=false;}}
function ft(a){if(a.h!==null){a.h.wb(a);}else if(a.h!==null){throw nu(new mu(),"This widget's parent does not implement HasWidgets");}}
function gt(b,a){if(b.g){qg(b.i,null);}bs(b,a);if(b.g){qg(a,b);}}
function ht(c,b){var a;a=c.h;if(b===null){if(a!==null&&a.g){et(c);}c.h=null;}else{if(a!==null){throw nu(new mu(),'Cannot set a new parent without first clearing the old parent');}c.h=b;if(b.g){dt(c);}}}
function it(){}
function jt(){}
function kt(a){}
function lt(){}
function mt(){}
function nt(a){gt(this,a);}
function qs(){}
_=qs.prototype=new zr();_.s=it;_.u=jt;_.eb=kt;_.lb=lt;_.mb=mt;_.Ab=nt;_.tN=lC+'Widget';_.tI=26;_.g=false;_.h=null;function rq(b,a){ht(a,b);}
function tq(b,a){ht(a,null);}
function uq(){var a,b;for(b=this.ab();vs(b);){a=ws(b);dt(a);}}
function vq(){var a,b;for(b=this.ab();vs(b);){a=ws(b);et(a);}}
function wq(){}
function xq(){}
function qq(){}
_=qq.prototype=new qs();_.s=uq;_.u=vq;_.lb=wq;_.mb=xq;_.tN=lC+'Panel';_.tI=27;function xn(a){a.f=As(new rs(),a);}
function yn(a){xn(a);return a;}
function zn(c,a,b){ft(a);Bs(c.f,a);of(b,a.i);rq(c,a);}
function Bn(b,c){var a;if(c.h!==b){return false;}tq(b,c);a=c.i;kg(gg(a),a);bt(b.f,c);return true;}
function Cn(){return Fs(this.f);}
function Dn(a){return Bn(this,a);}
function wn(){}
_=wn.prototype=new qq();_.ab=Cn;_.wb=Dn;_.tN=lC+'ComplexPanel';_.tI=28;function wm(a){yn(a);a.Ab(rf());tg(a.i,'position','relative');tg(a.i,'overflow','hidden');return a;}
function xm(a,b){zn(a,b,a.i);}
function zm(a){tg(a,'left','');tg(a,'top','');tg(a,'position','');}
function Am(b){var a;a=Bn(this,b);if(a){zm(b.i);}return a;}
function vm(){}
_=vm.prototype=new wn();_.wb=Am;_.tN=lC+'AbsolutePanel';_.tI=29;function ao(){ao=aC;xt(),zt;}
function Fn(b,a){xt(),zt;co(b,a);return b;}
function bo(b,a){switch(bg(a)){case 1:if(b.d!==null){un(b.d,b);}break;case 4096:case 2048:break;case 128:case 512:case 256:break;}}
function co(b,a){gt(b,a);es(b,7041);}
function eo(b,a){ng(b.i,'disabled',!a);}
function fo(a){if(this.d===null){this.d=sn(new rn());}dz(this.d,a);}
function go(a){bo(this,a);}
function ho(a){co(this,a);}
function En(){}
_=En.prototype=new qs();_.k=fo;_.eb=go;_.Ab=ho;_.tN=lC+'FocusWidget';_.tI=30;_.d=null;function Em(){Em=aC;xt(),zt;}
function Dm(b,a){xt(),zt;Fn(b,a);return b;}
function Fm(b,a){rg(b.i,a);}
function Cm(){}
_=Cm.prototype=new En();_.tN=lC+'ButtonBase';_.tI=31;function cn(){cn=aC;xt(),zt;}
function an(a){xt(),zt;Dm(a,qf());dn(a.i);cs(a,'gwt-Button');return a;}
function bn(b,a){xt(),zt;an(b);Fm(b,a);return b;}
function dn(b){cn();if(b.type=='submit'){try{b.setAttribute('type','button');}catch(a){}}}
function Bm(){}
_=Bm.prototype=new Cm();_.tN=lC+'Button';_.tI=32;function fn(a){yn(a);a.e=wf();a.d=tf();of(a.e,a.d);a.Ab(a.e);return a;}
function hn(a,b){if(b.h!==a){return null;}return gg(b.i);}
function kn(c,d,a){var b;b=hn(c,d);if(b!==null){jn(c,b,a);}}
function jn(c,b,a){pg(b,'align',a.a);}
function ln(c,b,a){tg(b,'verticalAlign',a.a);}
function en(){}
_=en.prototype=new wn();_.tN=lC+'CellPanel';_.tI=33;_.d=null;_.e=null;function Ew(d,a,b){var c;while(a.F()){c=a.cb();if(b===null?c===null:b.eQ(c)){return a;}}return null;}
function ax(a){throw Bw(new Aw(),'add');}
function bx(b){var a;a=Ew(this,this.ab(),b);return a!==null;}
function Dw(){}
_=Dw.prototype=new pv();_.n=ax;_.q=bx;_.tN=oC+'AbstractCollection';_.tI=0;function lx(b,a){throw qu(new pu(),'Index: '+a+', Size: '+b.b);}
function mx(b,a){throw Bw(new Aw(),'add');}
function nx(a){this.m(this.Bb(),a);return true;}
function ox(e){var a,b,c,d,f;if(e===this){return true;}if(!Cd(e,2)){return false;}f=Bd(e,2);if(this.Bb()!=f.Bb()){return false;}c=this.ab();d=f.ab();while(c.F()){a=c.cb();b=d.cb();if(!(a===null?b===null:a.eQ(b))){return false;}}return true;}
function px(){var a,b,c,d;c=1;a=31;b=this.ab();while(b.F()){d=b.cb();c=31*c+(d===null?0:d.hC());}return c;}
function qx(){return ex(new dx(),this);}
function rx(a){throw Bw(new Aw(),'remove');}
function cx(){}
_=cx.prototype=new Dw();_.m=mx;_.n=nx;_.eQ=ox;_.hC=px;_.ab=qx;_.vb=rx;_.tN=oC+'AbstractList';_.tI=34;function az(a){{ez(a);}}
function bz(a){az(a);return a;}
function cz(c,a,b){if(a<0||a>c.b){lx(c,a);}oz(c.a,a,b);++c.b;}
function dz(b,a){xz(b.a,b.b++,a);return true;}
function fz(a){ez(a);}
function ez(a){a.a=id();a.b=0;}
function hz(b,a){return jz(b,a)!=(-1);}
function iz(b,a){if(a<0||a>=b.b){lx(b,a);}return tz(b.a,a);}
function jz(b,a){return kz(b,a,0);}
function kz(c,b,a){if(a<0){lx(c,a);}for(;a<c.b;++a){if(sz(b,tz(c.a,a))){return a;}}return (-1);}
function lz(a){return a.b==0;}
function mz(c,a){var b;b=iz(c,a);vz(c.a,a,1);--c.b;return b;}
function nz(c,b){var a;a=jz(c,b);if(a==(-1)){return false;}mz(c,a);return true;}
function pz(a,b){cz(this,a,b);}
function qz(a){return dz(this,a);}
function oz(a,b,c){a.splice(b,0,c);}
function rz(a){return hz(this,a);}
function sz(a,b){return a===b||a!==null&&a.eQ(b);}
function uz(a){return iz(this,a);}
function tz(a,b){return a[b];}
function wz(a){return mz(this,a);}
function vz(a,c,b){a.splice(c,b);}
function xz(a,b,c){a[b]=c;}
function yz(){return this.b;}
function Fy(){}
_=Fy.prototype=new cx();_.m=pz;_.n=qz;_.q=rz;_.D=uz;_.vb=wz;_.Bb=yz;_.tN=oC+'ArrayList';_.tI=35;_.a=null;_.b=0;function nn(a){bz(a);return a;}
function pn(d,c){var a,b;for(a=d.ab();a.F();){b=Bd(a.cb(),12);b.fb(c);}}
function mn(){}
_=mn.prototype=new Fy();_.tN=lC+'ChangeListenerCollection';_.tI=36;function sn(a){bz(a);return a;}
function un(d,c){var a,b;for(a=d.ab();a.F();){b=Bd(a.cb(),13);b.gb(c);}}
function rn(){}
_=rn.prototype=new Fy();_.tN=lC+'ClickListenerCollection';_.tI=37;function wp(a){a.Ab(rf());es(a,131197);cs(a,'gwt-Label');return a;}
function xp(b,a){wp(b);zp(b,a);return b;}
function zp(b,a){sg(b.i,a);}
function Ap(a){switch(bg(a)){case 1:break;case 4:case 8:case 64:case 16:case 32:break;case 131072:break;}}
function vp(){}
_=vp.prototype=new qs();_.eb=Ap;_.tN=lC+'Label';_.tI=38;function jo(a){wp(a);a.Ab(rf());es(a,125);cs(a,'gwt-HTML');return a;}
function ko(b,a){jo(b);mo(b,a);return b;}
function mo(b,a){rg(b.i,a);}
function io(){}
_=io.prototype=new vp();_.tN=lC+'HTML';_.tI=39;function to(){to=aC;ro(new qo(),'center');uo=ro(new qo(),'left');vo=ro(new qo(),'right');}
var uo,vo;function ro(b,a){b.a=a;return b;}
function qo(){}
_=qo.prototype=new pv();_.tN=lC+'HasHorizontalAlignment$HorizontalAlignmentConstant';_.tI=0;_.a=null;function Bo(){Bo=aC;zo(new yo(),'bottom');zo(new yo(),'middle');Co=zo(new yo(),'top');}
var Co;function zo(a,b){a.a=b;return a;}
function yo(){}
_=yo.prototype=new pv();_.tN=lC+'HasVerticalAlignment$VerticalAlignmentConstant';_.tI=0;_.a=null;function ap(a){a.a=(to(),uo);a.c=(Bo(),Co);}
function bp(a){fn(a);ap(a);a.b=vf();of(a.d,a.b);pg(a.e,'cellSpacing','0');pg(a.e,'cellPadding','0');return a;}
function cp(b,c){var a;a=ep(b);of(b.b,a);zn(b,c,a);}
function ep(b){var a;a=uf();jn(b,a,b.a);ln(b,a,b.c);return a;}
function fp(c){var a,b;b=gg(c.i);a=Bn(this,c);if(a){kg(this.b,b);}return a;}
function Fo(){}
_=Fo.prototype=new en();_.wb=fp;_.tN=lC+'HorizontalPanel';_.tI=40;_.b=null;function np(a){bz(a);return a;}
function pp(f,e,b,d){var a,c;for(a=f.ab();a.F();){c=Bd(a.cb(),14);c.ib(e,b,d);}}
function qp(f,e,b,d){var a,c;for(a=f.ab();a.F();){c=Bd(a.cb(),14);c.jb(e,b,d);}}
function rp(f,e,b,d){var a,c;for(a=f.ab();a.F();){c=Bd(a.cb(),14);c.kb(e,b,d);}}
function sp(d,c,a){var b;b=tp(a);switch(bg(a)){case 128:pp(d,c,Dd(Ef(a)),b);break;case 512:rp(d,c,Dd(Ef(a)),b);break;case 256:qp(d,c,Dd(Ef(a)),b);break;}}
function tp(a){return (ag(a)?1:0)|(Ff(a)?8:0)|(Df(a)?2:0)|(Cf(a)?4:0);}
function mp(){}
_=mp.prototype=new Fy();_.tN=lC+'KeyboardListenerCollection';_.tI=41;function fq(){fq=aC;xt(),zt;oq=new Cp();}
function bq(a){fq();cq(a,false);return a;}
function cq(b,a){fq();Fn(b,sf(a));es(b,1024);cs(b,'gwt-ListBox');return b;}
function dq(b,a){jq(b,a,(-1));}
function eq(b,a){if(a<0||a>=gq(b)){throw new pu();}}
function gq(a){return Ep(oq,a.i);}
function hq(a){return dg(a.i,'selectedIndex');}
function iq(b,a){eq(b,a);return Fp(oq,b.i,a);}
function jq(c,b,a){kq(c,b,b,a);}
function kq(c,b,d,a){ig(c.i,b,d,a);}
function lq(c,a,b){eq(c,a);aq(oq,c.i,a,b);}
function mq(b,a){ng(b.i,'multiple',a);}
function nq(a,b){og(a.i,'size',b);}
function pq(a){if(bg(a)==1024){}else{bo(this,a);}}
function Bp(){}
_=Bp.prototype=new En();_.eb=pq;_.tN=lC+'ListBox';_.tI=42;var oq;function Ep(b,a){return a.options.length;}
function Fp(c,b,a){return b.options[a].value;}
function aq(d,b,a,c){b.options[a].selected=c;}
function Cp(){}
_=Cp.prototype=new pv();_.tN=lC+'ListBox$Impl';_.tI=0;function Eq(){Eq=aC;dr=vA(new Bz());}
function Dq(b,a){Eq();wm(b);if(a===null){a=Fq();}b.Ab(a);dt(b);return b;}
function ar(){Eq();return br(null);}
function br(c){Eq();var a,b;b=Bd(BA(dr,c),15);if(b!==null){return b;}a=null;if(dr.c==0){cr();}CA(dr,c,b=Dq(new yq(),a));return b;}
function Fq(){Eq();return $doc.body;}
function cr(){Eq();Dh(new zq());}
function yq(){}
_=yq.prototype=new vm();_.tN=lC+'RootPanel';_.tI=43;var dr;function Bq(){var a,b;for(b=fy(uy((Eq(),dr)));my(b);){a=Bd(ny(b),15);if(a.g){et(a);}}}
function Cq(){return null;}
function zq(){}
_=zq.prototype=new pv();_.nb=Bq;_.ob=Cq;_.tN=lC+'RootPanel$1';_.tI=44;function tr(){tr=aC;xt(),zt;}
function qr(b,a){xt(),zt;Fn(b,a);es(b,1024);return b;}
function rr(b,a){if(b.a===null){b.a=nn(new mn());}dz(b.a,a);}
function sr(b,a){if(b.c===null){b.c=np(new mp());}dz(b.c,a);}
function ur(a){return eg(a.i,'value');}
function vr(c,a){var b;ng(c.i,'readOnly',a);b='readonly';if(a){Ar(c,b);}else{Er(c,b);}}
function wr(b,a){pg(b.i,'value',a!==null?a:'');}
function xr(a){if(this.b===null){this.b=sn(new rn());}dz(this.b,a);}
function yr(a){var b;bo(this,a);b=bg(a);if(this.c!==null&&(b&896)!=0){sp(this.c,this,a);}else if(b==1){if(this.b!==null){un(this.b,this);}}else if(b==1024){if(this.a!==null){pn(this.a,this);}}}
function pr(){}
_=pr.prototype=new En();_.k=xr;_.eb=yr;_.tN=lC+'TextBoxBase';_.tI=45;_.a=null;_.b=null;_.c=null;function mr(){mr=aC;xt(),zt;}
function lr(a){xt(),zt;qr(a,xf());cs(a,'gwt-TextArea');return a;}
function nr(a,b){og(a.i,'cols',b);}
function or(b,a){og(b.i,'rows',a);}
function kr(){}
_=kr.prototype=new pr();_.tN=lC+'TextArea';_.tI=46;function ks(a){a.a=(to(),uo);a.b=(Bo(),Co);}
function ls(a){fn(a);ks(a);pg(a.e,'cellSpacing','0');pg(a.e,'cellPadding','0');return a;}
function ms(b,d){var a,c;c=vf();a=os(b);of(c,a);of(b.d,c);zn(b,d,a);}
function os(b){var a;a=uf();jn(b,a,b.a);ln(b,a,b.b);return a;}
function ps(c){var a,b;b=gg(c.i);a=Bn(this,c);if(a){kg(this.d,gg(b));}return a;}
function js(){}
_=js.prototype=new en();_.wb=ps;_.tN=lC+'VerticalPanel';_.tI=47;function As(b,a){b.b=a;b.a=vd('[Lcom.google.gwt.user.client.ui.Widget;',[0],[17],[4],null);return b;}
function Bs(a,b){Es(a,b,a.c);}
function Ds(b,c){var a;for(a=0;a<b.c;++a){if(b.a[a]===c){return a;}}return (-1);}
function Es(d,e,a){var b,c;if(a<0||a>d.c){throw new pu();}if(d.c==d.a.a){c=vd('[Lcom.google.gwt.user.client.ui.Widget;',[0],[17],[d.a.a*2],null);for(b=0;b<d.a.a;++b){wd(c,b,d.a[b]);}d.a=c;}++d.c;for(b=d.c-1;b>a;--b){wd(d.a,b,d.a[b-1]);}wd(d.a,a,e);}
function Fs(a){return ts(new ss(),a);}
function at(c,b){var a;if(b<0||b>=c.c){throw new pu();}--c.c;for(a=b;a<c.c;++a){wd(c.a,a,c.a[a+1]);}wd(c.a,c.c,null);}
function bt(b,c){var a;a=Ds(b,c);if(a==(-1)){throw new qB();}at(b,a);}
function rs(){}
_=rs.prototype=new pv();_.tN=lC+'WidgetCollection';_.tI=0;_.a=null;_.b=null;_.c=0;function ts(b,a){b.b=a;return b;}
function vs(a){return a.a<a.b.c-1;}
function ws(a){if(a.a>=a.b.c){throw new qB();}return a.b.a[++a.a];}
function xs(){return vs(this);}
function ys(){return ws(this);}
function zs(){if(this.a<0||this.a>=this.b.c){throw new mu();}this.b.b.wb(this.b.a[this.a--]);}
function ss(){}
_=ss.prototype=new pv();_.F=xs;_.cb=ys;_.ub=zs;_.tN=lC+'WidgetCollection$WidgetIterator';_.tI=0;_.a=(-1);function xt(){xt=aC;yt=rt(new pt());zt=yt!==null?wt(new ot()):yt;}
function wt(a){xt();return a;}
function ot(){}
_=ot.prototype=new pv();_.tN=mC+'FocusImpl';_.tI=0;var yt,zt;function st(){st=aC;xt();}
function qt(a){tt(a);ut(a);vt(a);}
function rt(a){st();wt(a);qt(a);return a;}
function tt(b){return function(a){if(this.parentNode.onblur){this.parentNode.onblur(a);}};}
function ut(b){return function(a){if(this.parentNode.onfocus){this.parentNode.onfocus(a);}};}
function vt(a){return function(){this.firstChild.focus();};}
function pt(){}
_=pt.prototype=new ot();_.tN=mC+'FocusImplOld';_.tI=0;function Bt(){}
_=Bt.prototype=new tv();_.tN=nC+'ArrayStoreException';_.tI=48;function au(a,b){if(b<2||b>36){return (-1);}if(a>=48&&a<48+Eu(b,10)){return a-48;}if(a>=97&&a<b+97-10){return a-97+10;}if(a>=65&&a<b+65-10){return a-65+10;}return (-1);}
function bu(){}
_=bu.prototype=new tv();_.tN=nC+'ClassCastException';_.tI=49;function ku(b,a){uv(b,a);return b;}
function ju(){}
_=ju.prototype=new tv();_.tN=nC+'IllegalArgumentException';_.tI=50;function nu(b,a){uv(b,a);return b;}
function mu(){}
_=mu.prototype=new tv();_.tN=nC+'IllegalStateException';_.tI=51;function qu(b,a){uv(b,a);return b;}
function pu(){}
_=pu.prototype=new tv();_.tN=nC+'IndexOutOfBoundsException';_.tI=52;function jv(){jv=aC;{ov();}}
function iv(a){jv();return a;}
function kv(a){jv();return isNaN(a);}
function lv(e,d,c,h){jv();var a,b,f,g;if(e===null){throw gv(new fv(),'Unable to parse null');}b=gw(e);f=b>0&&bw(e,0)==45?1:0;for(a=f;a<b;a++){if(au(bw(e,a),d)==(-1)){throw gv(new fv(),'Could not parse '+e+' in radix '+d);}}g=mv(e,d);if(kv(g)){throw gv(new fv(),'Unable to parse '+e);}else if(g<c||g>h){throw gv(new fv(),'The string '+e+' exceeds the range for the requested data type');}return g;}
function mv(b,a){jv();return parseInt(b,a);}
function ov(){jv();nv=/^[+-]?\d*\.?\d*(e[+-]?\d+)?$/i;}
function ev(){}
_=ev.prototype=new pv();_.tN=nC+'Number';_.tI=0;var nv=null;function uu(){uu=aC;jv();}
function tu(a,b){uu();iv(a);a.a=b;return a;}
function vu(a){return Cd(a,20)&&Bd(a,20).a==this.a;}
function wu(){return this.a;}
function xu(a){uu();return yu(a,10);}
function yu(b,a){uu();return Ed(lv(b,a,(-2147483648),2147483647));}
function zu(a){uu();return rw(a);}
function Au(a){uu();return tu(new su(),xu(a));}
function su(){}
_=su.prototype=new ev();_.eQ=vu;_.hC=wu;_.tN=nC+'Integer';_.tI=53;_.a=0;function Du(a){return a<0?-a:a;}
function Eu(a,b){return a<b?a:b;}
function Fu(){}
_=Fu.prototype=new tv();_.tN=nC+'NegativeArraySizeException';_.tI=54;function cv(b,a){uv(b,a);return b;}
function bv(){}
_=bv.prototype=new tv();_.tN=nC+'NullPointerException';_.tI=55;function gv(b,a){ku(b,a);return b;}
function fv(){}
_=fv.prototype=new ju();_.tN=nC+'NumberFormatException';_.tI=56;function bw(b,a){return b.charCodeAt(a);}
function dw(b,a){return b.indexOf(String.fromCharCode(a));}
function ew(b,a){return b.indexOf(a);}
function fw(c,b,a){return c.indexOf(b,a);}
function gw(a){return a.length;}
function hw(b,a){return ew(b,a)==0;}
function iw(b,a){return b.substr(a,b.length-a);}
function jw(c,a,b){return c.substr(a,b-a);}
function kw(c){var a=c.replace(/^(\s*)/,'');var b=a.replace(/\s*$/,'');return b;}
function lw(a,b){return String(a)==b;}
function mw(a){if(!Cd(a,1))return false;return lw(this,a);}
function ow(){var a=nw;if(!a){a=nw={};}var e=':'+this;var b=a[e];if(b==null){b=0;var f=this.length;var d=f<64?1:f/32|0;for(var c=0;c<f;c+=d){b<<=1;b+=this.charCodeAt(c);}b|=0;a[e]=b;}return b;}
function pw(a){return String.fromCharCode(a);}
function qw(a){return ''+a;}
function rw(a){return ''+a;}
_=String.prototype;_.eQ=mw;_.hC=ow;_.tN=nC+'String';_.tI=2;var nw=null;function zv(a){Cv(a);return a;}
function Av(a,b){return Bv(a,pw(b));}
function Bv(c,d){if(d===null){d='null';}var a=c.js.length-1;var b=c.js[a].length;if(c.length>b*b){c.js[a]=c.js[a]+d;}else{c.js.push(d);}c.length+=d.length;return c;}
function Cv(a){Dv(a,'');}
function Dv(b,a){b.js=[a];b.length=a.length;}
function Fv(a){a.db();return a.js[0];}
function aw(){if(this.js.length>1){this.js=[this.js.join('')];this.length=this.js[0].length;}}
function yv(){}
_=yv.prototype=new pv();_.db=aw;_.tN=nC+'StringBuffer';_.tI=0;function uw(){return new Date().getTime();}
function vw(a){return Dc(a);}
function Bw(b,a){uv(b,a);return b;}
function Aw(){}
_=Aw.prototype=new tv();_.tN=nC+'UnsupportedOperationException';_.tI=57;function ex(b,a){b.c=a;return b;}
function gx(a){return a.a<a.c.Bb();}
function hx(){return gx(this);}
function ix(){if(!gx(this)){throw new qB();}return this.c.D(this.b=this.a++);}
function jx(){if(this.b<0){throw new mu();}this.c.vb(this.b);this.a=this.b;this.b=(-1);}
function dx(){}
_=dx.prototype=new pv();_.F=hx;_.cb=ix;_.ub=jx;_.tN=oC+'AbstractList$IteratorImpl';_.tI=0;_.a=0;_.b=(-1);function sy(f,d,e){var a,b,c;for(b=qA(f.v());iA(b);){a=jA(b);c=a.z();if(d===null?c===null:d.eQ(c)){if(e){kA(b);}return a;}}return null;}
function ty(b){var a;a=b.v();return ux(new tx(),b,a);}
function uy(b){var a;a=AA(b);return dy(new cy(),b,a);}
function vy(a){return sy(this,a,false)!==null;}
function wy(d){var a,b,c,e,f,g,h;if(d===this){return true;}if(!Cd(d,21)){return false;}f=Bd(d,21);c=ty(this);e=f.bb();if(!Cy(c,e)){return false;}for(a=wx(c);Dx(a);){b=Ex(a);h=this.E(b);g=f.E(b);if(h===null?g!==null:!h.eQ(g)){return false;}}return true;}
function xy(b){var a;a=sy(this,b,false);return a===null?null:a.C();}
function yy(){var a,b,c;b=0;for(c=qA(this.v());iA(c);){a=jA(c);b+=a.hC();}return b;}
function zy(){return ty(this);}
function sx(){}
_=sx.prototype=new pv();_.p=vy;_.eQ=wy;_.E=xy;_.hC=yy;_.bb=zy;_.tN=oC+'AbstractMap';_.tI=58;function Cy(e,b){var a,c,d;if(b===e){return true;}if(!Cd(b,22)){return false;}c=Bd(b,22);if(c.Bb()!=e.Bb()){return false;}for(a=c.ab();a.F();){d=a.cb();if(!e.q(d)){return false;}}return true;}
function Dy(a){return Cy(this,a);}
function Ey(){var a,b,c;a=0;for(b=this.ab();b.F();){c=b.cb();if(c!==null){a+=c.hC();}}return a;}
function Ay(){}
_=Ay.prototype=new Dw();_.eQ=Dy;_.hC=Ey;_.tN=oC+'AbstractSet';_.tI=59;function ux(b,a,c){b.a=a;b.b=c;return b;}
function wx(b){var a;a=qA(b.b);return Bx(new Ax(),b,a);}
function xx(a){return this.a.p(a);}
function yx(){return wx(this);}
function zx(){return this.b.a.c;}
function tx(){}
_=tx.prototype=new Ay();_.q=xx;_.ab=yx;_.Bb=zx;_.tN=oC+'AbstractMap$1';_.tI=60;function Bx(b,a,c){b.a=c;return b;}
function Dx(a){return iA(a.a);}
function Ex(b){var a;a=jA(b.a);return a.z();}
function Fx(){return Dx(this);}
function ay(){return Ex(this);}
function by(){kA(this.a);}
function Ax(){}
_=Ax.prototype=new pv();_.F=Fx;_.cb=ay;_.ub=by;_.tN=oC+'AbstractMap$2';_.tI=0;function dy(b,a,c){b.a=a;b.b=c;return b;}
function fy(b){var a;a=qA(b.b);return ky(new jy(),b,a);}
function gy(a){return zA(this.a,a);}
function hy(){return fy(this);}
function iy(){return this.b.a.c;}
function cy(){}
_=cy.prototype=new Dw();_.q=gy;_.ab=hy;_.Bb=iy;_.tN=oC+'AbstractMap$3';_.tI=0;function ky(b,a,c){b.a=c;return b;}
function my(a){return iA(a.a);}
function ny(a){var b;b=jA(a.a).C();return b;}
function oy(){return my(this);}
function py(){return ny(this);}
function qy(){kA(this.a);}
function jy(){}
_=jy.prototype=new pv();_.F=oy;_.cb=py;_.ub=qy;_.tN=oC+'AbstractMap$4';_.tI=0;function xA(){xA=aC;EA=eB();}
function uA(a){{wA(a);}}
function vA(a){xA();uA(a);return a;}
function wA(a){a.a=id();a.d=kd();a.b=ce(EA,ed);a.c=0;}
function yA(b,a){if(Cd(a,1)){return iB(b.d,Bd(a,1))!==EA;}else if(a===null){return b.b!==EA;}else{return hB(b.a,a,a.hC())!==EA;}}
function zA(a,b){if(a.b!==EA&&gB(a.b,b)){return true;}else if(dB(a.d,b)){return true;}else if(bB(a.a,b)){return true;}return false;}
function AA(a){return oA(new eA(),a);}
function BA(c,a){var b;if(Cd(a,1)){b=iB(c.d,Bd(a,1));}else if(a===null){b=c.b;}else{b=hB(c.a,a,a.hC());}return b===EA?null:b;}
function CA(c,a,d){var b;{b=c.b;c.b=d;}if(b===EA){++c.c;return null;}else{return b;}}
function DA(c,a){var b;if(Cd(a,1)){b=lB(c.d,Bd(a,1));}else if(a===null){b=c.b;c.b=ce(EA,ed);}else{b=kB(c.a,a,a.hC());}if(b===EA){return null;}else{--c.c;return b;}}
function FA(e,c){xA();for(var d in e){if(d==parseInt(d)){var a=e[d];for(var f=0,b=a.length;f<b;++f){c.n(a[f]);}}}}
function aB(d,a){xA();for(var c in d){if(c.charCodeAt(0)==58){var e=d[c];var b=Fz(c.substring(1),e);a.n(b);}}}
function bB(f,h){xA();for(var e in f){if(e==parseInt(e)){var a=f[e];for(var g=0,b=a.length;g<b;++g){var c=a[g];var d=c.C();if(gB(h,d)){return true;}}}}return false;}
function cB(a){return yA(this,a);}
function dB(c,d){xA();for(var b in c){if(b.charCodeAt(0)==58){var a=c[b];if(gB(d,a)){return true;}}}return false;}
function eB(){xA();}
function fB(){return AA(this);}
function gB(a,b){xA();if(a===b){return true;}else if(a===null){return false;}else{return a.eQ(b);}}
function jB(a){return BA(this,a);}
function hB(f,h,e){xA();var a=f[e];if(a){for(var g=0,b=a.length;g<b;++g){var c=a[g];var d=c.z();if(gB(h,d)){return c.C();}}}}
function iB(b,a){xA();return b[':'+a];}
function kB(f,h,e){xA();var a=f[e];if(a){for(var g=0,b=a.length;g<b;++g){var c=a[g];var d=c.z();if(gB(h,d)){if(a.length==1){delete f[e];}else{a.splice(g,1);}return c.C();}}}}
function lB(c,a){xA();a=':'+a;var b=c[a];delete c[a];return b;}
function Bz(){}
_=Bz.prototype=new sx();_.p=cB;_.v=fB;_.E=jB;_.tN=oC+'HashMap';_.tI=61;_.a=null;_.b=null;_.c=0;_.d=null;var EA;function Dz(b,a,c){b.a=a;b.b=c;return b;}
function Fz(a,b){return Dz(new Cz(),a,b);}
function aA(b){var a;if(Cd(b,23)){a=Bd(b,23);if(gB(this.a,a.z())&&gB(this.b,a.C())){return true;}}return false;}
function bA(){return this.a;}
function cA(){return this.b;}
function dA(){var a,b;a=0;b=0;if(this.a!==null){a=this.a.hC();}if(this.b!==null){b=this.b.hC();}return a^b;}
function Cz(){}
_=Cz.prototype=new pv();_.eQ=aA;_.z=bA;_.C=cA;_.hC=dA;_.tN=oC+'HashMap$EntryImpl';_.tI=62;_.a=null;_.b=null;function oA(b,a){b.a=a;return b;}
function qA(a){return gA(new fA(),a.a);}
function rA(c){var a,b,d;if(Cd(c,23)){a=Bd(c,23);b=a.z();if(yA(this.a,b)){d=BA(this.a,b);return gB(a.C(),d);}}return false;}
function sA(){return qA(this);}
function tA(){return this.a.c;}
function eA(){}
_=eA.prototype=new Ay();_.q=rA;_.ab=sA;_.Bb=tA;_.tN=oC+'HashMap$EntrySet';_.tI=63;function gA(c,b){var a;c.c=b;a=bz(new Fy());if(c.c.b!==(xA(),EA)){dz(a,Dz(new Cz(),null,c.c.b));}aB(c.c.d,a);FA(c.c.a,a);c.a=a.ab();return c;}
function iA(a){return a.a.F();}
function jA(a){return a.b=Bd(a.a.cb(),23);}
function kA(a){if(a.b===null){throw nu(new mu(),'Must call next() before remove().');}else{a.a.ub();DA(a.c,a.b.z());a.b=null;}}
function lA(){return iA(this);}
function mA(){return jA(this);}
function nA(){kA(this);}
function fA(){}
_=fA.prototype=new pv();_.F=lA;_.cb=mA;_.ub=nA;_.tN=oC+'HashMap$EntrySetIterator';_.tI=0;_.a=null;_.b=null;function qB(){}
_=qB.prototype=new tv();_.tN=oC+'NoSuchElementException';_.tI=64;function vB(a){a.a=bz(new Fy());return a;}
function wB(b,a){return dz(b.a,a);}
function yB(a){return a.a.ab();}
function zB(a,b){cz(this.a,a,b);}
function AB(a){return wB(this,a);}
function BB(a){return hz(this.a,a);}
function CB(a){return iz(this.a,a);}
function DB(){return yB(this);}
function EB(a){return mz(this.a,a);}
function FB(){return this.a.b;}
function uB(){}
_=uB.prototype=new cx();_.m=zB;_.n=AB;_.q=BB;_.D=CB;_.ab=DB;_.vb=EB;_.Bb=FB;_.tN=oC+'Vector';_.tI=65;_.a=null;function At(){vb(new ab());}
function gwtOnLoad(b,d,c){$moduleName=d;$moduleBase=c;if(b)try{At();}catch(a){b(d);}else{At();}}
var be=[{},{},{1:1},{3:1},{11:1},{7:1},{12:1},{14:1},{14:1},{13:1},{5:1},{5:1},{5:1},{5:1},{6:1},{5:1},{9:1},{9:1},{9:1},{6:1,8:1},{6:1},{10:1},{5:1},{5:1},{4:1,5:1},{5:1},{16:1,17:1,18:1,19:1},{16:1,17:1,18:1,19:1},{16:1,17:1,18:1,19:1},{16:1,17:1,18:1,19:1},{16:1,17:1,18:1,19:1},{16:1,17:1,18:1,19:1},{16:1,17:1,18:1,19:1},{16:1,17:1,18:1,19:1},{2:1},{2:1},{2:1},{2:1},{16:1,17:1,18:1,19:1},{16:1,17:1,18:1,19:1},{16:1,17:1,18:1,19:1},{2:1},{16:1,17:1,18:1,19:1},{15:1,16:1,17:1,18:1,19:1},{10:1},{16:1,17:1,18:1,19:1},{16:1,17:1,18:1,19:1},{16:1,17:1,18:1,19:1},{5:1},{5:1},{5:1},{5:1},{5:1},{20:1},{5:1},{5:1},{5:1},{5:1},{21:1},{22:1},{22:1},{21:1},{23:1},{22:1},{5:1},{2:1}];if (TFDSSummarizer) {  var __gwt_initHandlers = TFDSSummarizer.__gwt_initHandlers;  TFDSSummarizer.onScriptLoad(gwtOnLoad);}})();