(function(){var $wnd = window;var $doc = $wnd.document;var $moduleName, $moduleBase;var _,aC='client.',bC='client.service.',cC='com.google.gwt.core.client.',dC='com.google.gwt.lang.',eC='com.google.gwt.user.client.',fC='com.google.gwt.user.client.impl.',gC='com.google.gwt.user.client.rpc.',hC='com.google.gwt.user.client.rpc.core.java.lang.',iC='com.google.gwt.user.client.rpc.core.java.util.',jC='com.google.gwt.user.client.rpc.impl.',kC='com.google.gwt.user.client.ui.',lC='com.google.gwt.user.client.ui.impl.',mC='java.lang.',nC='java.util.';function FB(){}
function qv(a){return this===a;}
function rv(){return uw(this);}
function ov(){}
_=ov.prototype={};_.eQ=qv;_.hC=rv;_.tN=mC+'Object';_.tI=1;function s(){}
_=s.prototype=new ov();_.tN=aC+'Sentence';_.tI=3;_.a=0.0;_.b=0;_.c=0;_.d='';function w(b,a){C(a,b.qb());D(a,b.rb());E(a,b.rb());F(a,b.tb());}
function x(a){return a.a;}
function y(a){return a.b;}
function z(a){return a.c;}
function A(a){return a.d;}
function B(b,a){b.Cb(x(a));b.Db(y(a));b.Db(z(a));b.Fb(A(a));}
function C(a,b){a.a=b;}
function D(a,b){a.b=b;}
function E(a,b){a.c=b;}
function F(a,b){a.d=b;}
function vb(r){var a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q;c=Ap(new yp(),'Input text to be summarized:');g=or(new nr());qr(g,80);rr(g,25);a=en(new Em(),'Summarize');o=Ap(new yp(),'Summary Size (% of original):');p=eq(new Ep());for(b=1;b<=100;b++)gq(p,yu(b));pq(p,false);qq(p,1);oq(p,9,true);d=ep(new cp());fp(d,a);fp(d,o);fp(d,p);nn(d,o,(wo(),yo));nn(d,p,(wo(),yo));gs(d,'95%');e=os(new ms());ps(e,c);ps(e,g);ps(e,d);j=Ap(new yp(),'System-generated Summary:');l=or(new nr());qr(l,80);rr(l,25);yr(l,true);n=mo(new lo());k=os(new ms());ps(k,j);ps(k,l);ps(k,n);f=no(new lo(),'<br><br><br>This summarizer implements the frequency distribution summarization algorithm (using terms rather than concepts) described in these papers:<br><br>Lawrence H. Reeve, Hyoil Han, Saya V. Nagori, Jonathan C. Yang, Tamara A. Schwimmer, and Ari D. Brooks (2006).<br><EM><A href="http://cluster.cis.drexel.edu:8080/biotus/pubs/2006CIKM.pdf">Concept Frequency Distribution in Biomedical Text Summarization<\/A>.<\/EM><br><A href="http://sa1.sice.umkc.edu/cikm2006/"> <FONT face="Times New Roman">Proceedings of the 15th Conference on Information and Knowledge Management<\/FONT><\/A><FONT face="Times New Roman"><\/FONT><A href="http://www.cs.iupui.edu/%7Ebioin/"><\/A>.<br><br>Lawrence H. Reeve and Hyoil Han (2007).<br><EM><a href="http://cluster.cis.drexel.edu:8080/biotus/pubs/2007DUC.pdf">A Term Frequency Distribution Approach for the DUC-2007 Update Task.<\/a><\/EM><br>Proceedings of the 2007 Document Understanding Conference Workshop (DUC 2007)<br><br>');m=ep(new cp());fp(m,f);h=ep(new cp());fp(h,e);fp(h,k);Eh(r);Am(dr(),h);Am(dr(),m);r.b=Eb(new yb());q=r.b;i=xc()+'summarizerservice';bc(q,i);r.a=cb(new bb(),r,l,n,a);zg(new gb());ei(),di();ur(g,new jb());vr(g,nb(new mb(),r,l));a.k(rb(new qb(),r,a,l,n,g,p));}
function wb(b,a){}
function ab(){}
_=ab.prototype=new ov();_.pb=wb;_.tN=aC+'TFDSSummarizer';_.tI=4;_.a=null;_.b=null;function cb(b,a,d,e,c){b.b=d;b.c=e;b.a=c;return b;}
function eb(b,a){po(b.c,'Server Response:\n\n'+a.a);ho(b.a,true);}
function fb(g,c){var a,b,d,e,f;f=Bd(c,2);b=yv(new xv());for(a=0;a<f.Bb();a++){d=Bd(f.D(a),3);if(d.c==0){e=d.d;if(e!==null&&fw(e)!=0){Av(b,d.d);Av(b,'\n\n');}}else{Av(b,'['+d.c+']: '+d.d);Av(b,'\n\n');}}zr(g.b,Ev(b));Cp(g.c,'');ho(g.a,true);}
function bb(){}
_=bb.prototype=new ov();_.tN=aC+'TFDSSummarizer$1';_.tI=0;function ib(){ei(),di();}
function gb(){}
_=gb.prototype=new ov();_.w=ib;_.tN=aC+'TFDSSummarizer$2';_.tI=5;function lb(a){}
function jb(){}
_=jb.prototype=new ov();_.fb=lb;_.tN=aC+'TFDSSummarizer$3';_.tI=6;function mp(c,a,b){}
function np(c,a,b){}
function op(c,a,b){}
function kp(){}
_=kp.prototype=new ov();_.ib=mp;_.jb=np;_.kb=op;_.tN=kC+'KeyboardListenerAdapter';_.tI=7;function nb(b,a,c){b.a=c;return b;}
function pb(d,a,b){var c;c=xr(this.a);if(c!==null&&fw(c)>0)zr(this.a,'');}
function mb(){}
_=mb.prototype=new kp();_.jb=pb;_.tN=aC+'TFDSSummarizer$4';_.tI=8;function rb(b,a,c,e,f,d,g){b.a=a;b.b=c;b.d=e;b.e=f;b.c=d;b.f=g;return b;}
function tb(a){ho(this.b,false);zr(this.d,'');po(this.e,'<b><i>Please wait...summarizing the source text.<\/i><\/b>');cc(this.a.b,xr(this.c),zu(lq(this.f,kq(this.f))),this.a.a);}
function qb(){}
_=qb.prototype=new ov();_.gb=tb;_.tN=aC+'TFDSSummarizer$5';_.tI=9;function ac(){ac=FB;dc=fc(new ec());}
function Eb(a){ac();return a;}
function Fb(d,b,c,a){if(d.a===null)throw kk(new jk());jm(b);ml(b,'client.service.ISummarizerService');ml(b,'summarizeTFDS');kl(b,2);ml(b,'java.lang.String');ml(b,'java.lang.Integer');ml(b,c);ll(b,a);}
function bc(b,a){b.a=a;}
function cc(j,i,f,c){var a,d,e,g,h;g=wl(new vl(),dc);h=fm(new dm(),dc,xc(),'AF8D9E63B5457AB80016BBD0E4B3C585');try{Fb(j,h,i,f);}catch(a){a=fe(a);if(Cd(a,4)){d=a;eb(c,d);return;}else throw a;}e=Ab(new zb(),j,g,c);if(!gh(j.a,mm(h),e))eb(c,bk(new ak(),'Unable to initiate the asynchronous service invocation -- check the network connection'));}
function yb(){}
_=yb.prototype=new ov();_.tN=bC+'ISummarizerService_Proxy';_.tI=0;_.a=null;var dc;function Ab(b,a,d,c){b.b=d;b.a=c;return b;}
function Cb(g,e){var a,c,d,f;f=null;c=null;try{if(gw(e,'//OK')){zl(g.b,hw(e,4));f=fl(g.b);}else if(gw(e,'//EX')){zl(g.b,hw(e,4));c=Bd(fl(g.b),5);}else{c=bk(new ak(),e);}}catch(a){a=fe(a);if(Cd(a,4)){a;c=Aj(new zj());}else if(Cd(a,5)){d=a;c=d;}else throw a;}if(c===null)fb(g.a,f);else eb(g.a,c);}
function Db(a){var b;b=zc;Cb(this,a);}
function zb(){}
_=zb.prototype=new ov();_.hb=Db;_.tN=bC+'ISummarizerService_Proxy$1';_.tI=0;function gc(){gc=FB;rc=lc();tc=mc();}
function fc(a){gc();return a;}
function hc(d,c,a,e){var b=rc[e];if(!b){sc(e);}b[1](c,a);}
function ic(b,c){var a=tc[c];return a==null?c:a;}
function jc(c,b,d){var a=rc[d];if(!a){sc(d);}return a[0](b);}
function kc(d,c,a,e){var b=rc[e];if(!b){sc(e);}b[2](c,a);}
function lc(){gc();return {'client.Sentence/1365443775':[function(a){return nc(a);},function(a,b){w(a,b);},function(a,b){B(a,b);}],'com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException/3936916533':[function(a){return oc(a);},function(a,b){Ej(a,b);},function(a,b){Fj(a,b);}],'java.lang.Integer/3438268394':[function(a){return qk(a);},function(a,b){pk(a,b);},function(a,b){rk(a,b);}],'java.lang.String/2004016611':[function(a){return vk(a);},function(a,b){uk(a,b);},function(a,b){wk(a,b);}],'java.util.ArrayList/3821976829':[function(a){return pc(a);},function(a,b){zk(a,b);},function(a,b){Ak(a,b);}],'java.util.Vector/3125574444':[function(a){return qc(a);},function(a,b){Dk(a,b);},function(a,b){Ek(a,b);}]};}
function mc(){gc();return {'client.Sentence':'1365443775','com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException':'3936916533','java.lang.Integer':'3438268394','java.lang.String':'2004016611','java.util.ArrayList':'3821976829','java.util.Vector':'3125574444'};}
function nc(a){gc();return new s();}
function oc(a){gc();return Aj(new zj());}
function pc(a){gc();return az(new Ey());}
function qc(a){gc();return uB(new tB());}
function sc(a){gc();throw fk(new ek(),a);}
function ec(){}
_=ec.prototype=new ov();_.tN=bC+'ISummarizerService_TypeSerializer';_.tI=0;var rc,tc;function xc(){return Ec();}
function yc(a){return a==null?null:a.tN;}
var zc=null;function Cc(a){return a==null?0:a.$H?a.$H:(a.$H=Fc());}
function Dc(a){return a==null?0:a.$H?a.$H:(a.$H=Fc());}
function Ec(){return $moduleBase;}
function Fc(){return ++ad;}
var ad=0;function ww(b,a){b.a=a;return b;}
function xw(c,b,a){c.a=b;return c;}
function vw(){}
_=vw.prototype=new ov();_.tN=mC+'Throwable';_.tI=10;_.a=null;function fu(b,a){ww(b,a);return b;}
function gu(c,b,a){xw(c,b,a);return c;}
function eu(){}
_=eu.prototype=new vw();_.tN=mC+'Exception';_.tI=11;function tv(b,a){fu(b,a);return b;}
function uv(c,b,a){gu(c,b,a);return c;}
function sv(){}
_=sv.prototype=new eu();_.tN=mC+'RuntimeException';_.tI=12;function cd(c,b,a){tv(c,'JavaScript '+b+' exception: '+a);return c;}
function bd(){}
_=bd.prototype=new sv();_.tN=cC+'JavaScriptException';_.tI=13;function gd(b,a){if(!Cd(a,6)){return false;}return ld(b,Bd(a,6));}
function hd(a){return Cc(a);}
function id(){return [];}
function jd(){return function(){};}
function kd(){return {};}
function md(a){return gd(this,a);}
function ld(a,b){return a===b;}
function nd(){return hd(this);}
function ed(){}
_=ed.prototype=new ov();_.eQ=md;_.hC=nd;_.tN=cC+'JavaScriptObject';_.tI=14;function pd(c,a,d,b,e){c.a=a;c.b=b;c.tN=e;c.tI=d;return c;}
function rd(a,b,c){return a[b]=c;}
function sd(b,a){return b[a];}
function td(a){return a.length;}
function vd(e,d,c,b,a){return ud(e,d,c,b,0,td(b),a);}
function ud(j,i,g,c,e,a,b){var d,f,h;if((f=sd(c,e))<0){throw new Eu();}h=pd(new od(),f,sd(i,e),sd(g,e),j);++e;if(e<a){j=hw(j,1);for(d=0;d<f;++d){rd(h,d,ud(j,i,g,c,e,a,b));}}else{for(d=0;d<f;++d){rd(h,d,b);}}return h;}
function wd(a,b,c){if(c!==null&&a.b!=0&& !Cd(c,a.b)){throw new At();}return rd(a,b,c);}
function od(){}
_=od.prototype=new ov();_.tN=dC+'Array';_.tI=0;function zd(b,a){return !(!(b&&be[b][a]));}
function Ad(a){return String.fromCharCode(a);}
function Bd(b,a){if(b!=null)zd(b.tI,a)||ae();return b;}
function Cd(b,a){return b!=null&&zd(b.tI,a);}
function Dd(a){return a&65535;}
function Ed(a){return ~(~a);}
function ae(){throw new au();}
function Fd(a){if(a!==null){throw new au();}return a;}
function ce(b,d){_=d.prototype;if(b&& !(b.tI>=_.tI)){var c=b.toString;for(var a in _){b[a]=_[a];}b.toString=c;}return b;}
var be;function fe(a){if(Cd(a,5)){return a;}return cd(new bd(),he(a),ge(a));}
function ge(a){return a.message;}
function he(a){return a.name;}
function je(b,a){return b;}
function ie(){}
_=ie.prototype=new sv();_.tN=eC+'CommandCanceledException';_.tI=15;function af(a){a.a=ne(new me(),a);a.b=az(new Ey());a.d=re(new qe(),a);a.f=ve(new ue(),a);}
function bf(a){af(a);return a;}
function df(c){var a,b,d;a=xe(c.f);Ae(c.f);b=null;if(Cd(a,7)){b=je(new ie(),Bd(a,7));}else{}if(b!==null){d=zc;}gf(c,false);ff(c);}
function ef(e,d){var a,b,c,f;f=false;try{gf(e,true);Be(e.f,e.b.b);sh(e.a,10000);while(ye(e.f)){b=ze(e.f);c=true;try{if(b===null){return;}if(Cd(b,7)){a=Bd(b,7);a.w();}else{}}finally{f=Ce(e.f);if(f){return;}if(c){Ae(e.f);}}if(kf(tw(),d)){return;}}}finally{if(!f){ph(e.a);gf(e,false);ff(e);}}}
function ff(a){if(!kz(a.b)&& !a.e&& !a.c){hf(a,true);sh(a.d,1);}}
function gf(b,a){b.c=a;}
function hf(b,a){b.e=a;}
function jf(b,a){cz(b.b,a);ff(b);}
function kf(a,b){return Cu(a-b)>=100;}
function le(){}
_=le.prototype=new ov();_.tN=eC+'CommandExecutor';_.tI=0;_.c=false;_.e=false;function qh(){qh=FB;yh=az(new Ey());{xh();}}
function oh(a){qh();return a;}
function ph(a){if(a.b){th(a.c);}else{uh(a.c);}mz(yh,a);}
function rh(a){if(!a.b){mz(yh,a);}a.xb();}
function sh(b,a){if(a<=0){throw ju(new iu(),'must be positive');}ph(b);b.b=false;b.c=vh(b,a);cz(yh,b);}
function th(a){qh();$wnd.clearInterval(a);}
function uh(a){qh();$wnd.clearTimeout(a);}
function vh(b,a){qh();return $wnd.setTimeout(function(){b.x();},a);}
function wh(){var a;a=zc;{rh(this);}}
function xh(){qh();Dh(new kh());}
function jh(){}
_=jh.prototype=new ov();_.x=wh;_.tN=eC+'Timer';_.tI=16;_.b=false;_.c=0;var yh;function oe(){oe=FB;qh();}
function ne(b,a){oe();b.a=a;oh(b);return b;}
function pe(){if(!this.a.c){return;}df(this.a);}
function me(){}
_=me.prototype=new jh();_.xb=pe;_.tN=eC+'CommandExecutor$1';_.tI=17;function se(){se=FB;qh();}
function re(b,a){se();b.a=a;oh(b);return b;}
function te(){hf(this.a,false);ef(this.a,tw());}
function qe(){}
_=qe.prototype=new jh();_.xb=te;_.tN=eC+'CommandExecutor$2';_.tI=18;function ve(b,a){b.d=a;return b;}
function xe(a){return hz(a.d.b,a.b);}
function ye(a){return a.c<a.a;}
function ze(b){var a;b.b=b.c;a=hz(b.d.b,b.c++);if(b.c>=b.a){b.c=0;}return a;}
function Ae(a){lz(a.d.b,a.b);--a.a;if(a.b<=a.c){if(--a.c<0){a.c=0;}}a.b=(-1);}
function Be(b,a){b.a=a;}
function Ce(a){return a.b==(-1);}
function De(){return ye(this);}
function Ee(){return ze(this);}
function Fe(){Ae(this);}
function ue(){}
_=ue.prototype=new ov();_.F=De;_.cb=Ee;_.ub=Fe;_.tN=eC+'CommandExecutor$CircularIterator';_.tI=0;_.a=0;_.b=(-1);_.c=0;function nf(){nf=FB;mg=az(new Ey());{hg=new li();ri(hg);}}
function of(b,a){nf();wi(hg,b,a);}
function pf(a,b){nf();return ni(hg,a,b);}
function qf(){nf();return yi(hg,'button');}
function rf(){nf();return yi(hg,'div');}
function sf(a){nf();return oi(hg,a);}
function tf(){nf();return yi(hg,'tbody');}
function uf(){nf();return yi(hg,'td');}
function vf(){nf();return yi(hg,'tr');}
function wf(){nf();return yi(hg,'table');}
function xf(){nf();return yi(hg,'textarea');}
function Af(b,a,d){nf();var c;c=zc;{zf(b,a,d);}}
function zf(b,a,c){nf();var d;if(a===lg){if(bg(b)==8192){lg=null;}}d=yf;yf=b;try{c.eb(b);}finally{yf=d;}}
function Bf(b,a){nf();zi(hg,b,a);}
function Cf(a){nf();return Ai(hg,a);}
function Df(a){nf();return Bi(hg,a);}
function Ef(a){nf();return Ci(hg,a);}
function Ff(a){nf();return Di(hg,a);}
function ag(a){nf();return Ei(hg,a);}
function bg(a){nf();return Fi(hg,a);}
function cg(a){nf();pi(hg,a);}
function eg(a,b){nf();return bj(hg,a,b);}
function dg(a,b){nf();return aj(hg,a,b);}
function fg(a){nf();return cj(hg,a);}
function gg(a){nf();return qi(hg,a);}
function ig(c,b,d,a){nf();si(hg,c,b,d,a);}
function jg(a){nf();var b,c;c=true;if(mg.b>0){b=Fd(hz(mg,mg.b-1));if(!(c=null.bc())){Bf(a,true);cg(a);}}return c;}
function kg(b,a){nf();dj(hg,b,a);}
function pg(a,b,c){nf();gj(hg,a,b,c);}
function ng(a,b,c){nf();ej(hg,a,b,c);}
function og(a,b,c){nf();fj(hg,a,b,c);}
function qg(a,b){nf();hj(hg,a,b);}
function rg(a,b){nf();ij(hg,a,b);}
function sg(a,b){nf();ti(hg,a,b);}
function tg(b,a,c){nf();jj(hg,b,a,c);}
function ug(a,b){nf();ui(hg,a,b);}
function vg(){nf();return kj(hg);}
function wg(){nf();return lj(hg);}
var yf=null,hg=null,lg=null,mg;function yg(){yg=FB;Ag=bf(new le());}
function zg(a){yg();if(a===null){throw bv(new av(),'cmd can not be null');}jf(Ag,a);}
var Ag;function Dg(a){if(Cd(a,8)){return pf(this,Bd(a,8));}return gd(ce(this,Bg),a);}
function Eg(){return hd(ce(this,Bg));}
function Bg(){}
_=Bg.prototype=new ed();_.eQ=Dg;_.hC=Eg;_.tN=eC+'Element';_.tI=19;function ch(a){return gd(ce(this,Fg),a);}
function dh(){return hd(ce(this,Fg));}
function Fg(){}
_=Fg.prototype=new ed();_.eQ=ch;_.hC=dh;_.tN=eC+'Event';_.tI=20;function fh(){fh=FB;hh=oj(new nj());}
function gh(c,b,a){fh();return tj(hh,c,b,a);}
var hh;function mh(){while((qh(),yh).b>0){ph(Bd(hz((qh(),yh),0),9));}}
function nh(){return null;}
function kh(){}
_=kh.prototype=new ov();_.nb=mh;_.ob=nh;_.tN=eC+'Timer$1';_.tI=21;function Ch(){Ch=FB;Fh=az(new Ey());ji=az(new Ey());{fi();}}
function Dh(a){Ch();cz(Fh,a);}
function Eh(a){Ch();cz(ji,a);}
function ai(){Ch();var a,b;for(a=Fh.ab();a.F();){b=Bd(a.cb(),10);b.nb();}}
function bi(){Ch();var a,b,c,d;d=null;for(a=Fh.ab();a.F();){b=Bd(a.cb(),10);c=b.ob();{d=c;}}return d;}
function ci(){Ch();var a,b;for(a=ji.ab();a.F();){b=Bd(a.cb(),11);b.pb(ei(),di());}}
function di(){Ch();return vg();}
function ei(){Ch();return wg();}
function fi(){Ch();__gwt_initHandlers(function(){ii();},function(){return hi();},function(){gi();$wnd.onresize=null;$wnd.onbeforeclose=null;$wnd.onclose=null;});}
function gi(){Ch();var a;a=zc;{ai();}}
function hi(){Ch();var a;a=zc;{return bi();}}
function ii(){Ch();var a;a=zc;{ci();}}
var Fh,ji;function wi(c,b,a){b.appendChild(a);}
function yi(b,a){return $doc.createElement(a);}
function zi(c,b,a){b.cancelBubble=a;}
function Ai(b,a){return !(!a.altKey);}
function Bi(b,a){return !(!a.ctrlKey);}
function Ci(b,a){return a.which||(a.keyCode|| -1);}
function Di(b,a){return !(!a.metaKey);}
function Ei(b,a){return !(!a.shiftKey);}
function Fi(b,a){switch(a.type){case 'blur':return 4096;case 'change':return 1024;case 'click':return 1;case 'dblclick':return 2;case 'focus':return 2048;case 'keydown':return 128;case 'keypress':return 256;case 'keyup':return 512;case 'load':return 32768;case 'losecapture':return 8192;case 'mousedown':return 4;case 'mousemove':return 64;case 'mouseout':return 32;case 'mouseover':return 16;case 'mouseup':return 8;case 'scroll':return 16384;case 'error':return 65536;case 'mousewheel':return 131072;case 'DOMMouseScroll':return 131072;}}
function bj(d,a,b){var c=a[b];return c==null?null:String(c);}
function aj(d,a,c){var b=parseInt(a[c]);if(!b){return 0;}return b;}
function cj(b,a){return a.__eventBits||0;}
function dj(c,b,a){b.removeChild(a);}
function gj(c,a,b,d){a[b]=d;}
function ej(c,a,b,d){a[b]=d;}
function fj(c,a,b,d){a[b]=d;}
function hj(c,a,b){a.__listener=b;}
function ij(c,a,b){if(!b){b='';}a.innerHTML=b;}
function jj(c,b,a,d){b.style[a]=d;}
function kj(a){return $doc.body.clientHeight;}
function lj(a){return $doc.body.clientWidth;}
function ki(){}
_=ki.prototype=new ov();_.tN=fC+'DOMImpl';_.tI=0;function ni(c,a,b){if(!a&& !b)return true;else if(!a|| !b)return false;return a.uniqueID==b.uniqueID;}
function oi(c,b){var a=b?'<SELECT MULTIPLE>':'<SELECT>';return $doc.createElement(a);}
function pi(b,a){a.returnValue=false;}
function qi(c,a){var b=a.parentElement;return b||null;}
function ri(d){try{$doc.execCommand('BackgroundImageCache',false,true);}catch(a){}$wnd.__dispatchEvent=function(){var c=vi;vi=this;if($wnd.event.returnValue==null){$wnd.event.returnValue=true;if(!jg($wnd.event)){vi=c;return;}}var b,a=this;while(a&& !(b=a.__listener))a=a.parentElement;if(b)Af($wnd.event,a,b);vi=c;};$wnd.__dispatchDblClickEvent=function(){var a=$doc.createEventObject();this.fireEvent('onclick',a);if(this.__eventBits&2)$wnd.__dispatchEvent.call(this);};$doc.body.onclick=$doc.body.onmousedown=$doc.body.onmouseup=$doc.body.onmousemove=$doc.body.onmousewheel=$doc.body.onkeydown=$doc.body.onkeypress=$doc.body.onkeyup=$doc.body.onfocus=$doc.body.onblur=$doc.body.ondblclick=$wnd.__dispatchEvent;}
function si(e,c,d,f,a){var b=new Option(d,f);if(a== -1||a>c.options.length-1){c.add(b);}else{c.add(b,a);}}
function ti(c,a,b){if(!b)b='';a.innerText=b;}
function ui(c,b,a){b.__eventBits=a;b.onclick=a&1?$wnd.__dispatchEvent:null;b.ondblclick=a&(1|2)?$wnd.__dispatchDblClickEvent:null;b.onmousedown=a&4?$wnd.__dispatchEvent:null;b.onmouseup=a&8?$wnd.__dispatchEvent:null;b.onmouseover=a&16?$wnd.__dispatchEvent:null;b.onmouseout=a&32?$wnd.__dispatchEvent:null;b.onmousemove=a&64?$wnd.__dispatchEvent:null;b.onkeydown=a&128?$wnd.__dispatchEvent:null;b.onkeypress=a&256?$wnd.__dispatchEvent:null;b.onkeyup=a&512?$wnd.__dispatchEvent:null;b.onchange=a&1024?$wnd.__dispatchEvent:null;b.onfocus=a&2048?$wnd.__dispatchEvent:null;b.onblur=a&4096?$wnd.__dispatchEvent:null;b.onlosecapture=a&8192?$wnd.__dispatchEvent:null;b.onscroll=a&16384?$wnd.__dispatchEvent:null;b.onload=a&32768?$wnd.__dispatchEvent:null;b.onerror=a&65536?$wnd.__dispatchEvent:null;b.onmousewheel=a&131072?$wnd.__dispatchEvent:null;}
function li(){}
_=li.prototype=new ki();_.tN=fC+'DOMImplIE6';_.tI=0;var vi=null;function rj(a){xj=jd();return a;}
function tj(c,d,b,a){return uj(c,null,null,d,b,a);}
function uj(d,f,c,e,b,a){return sj(d,f,c,e,b,a);}
function sj(e,g,d,f,c,b){var h=e.t();try{h.open('POST',f,true);h.setRequestHeader('Content-Type','text/plain; charset=utf-8');h.onreadystatechange=function(){if(h.readyState==4){h.onreadystatechange=xj;b.hb(h.responseText||'');}};h.send(c);return true;}catch(a){h.onreadystatechange=xj;return false;}}
function wj(){return new XMLHttpRequest();}
function mj(){}
_=mj.prototype=new ov();_.t=wj;_.tN=fC+'HTTPRequestImpl';_.tI=0;var xj=null;function oj(a){rj(a);return a;}
function qj(){return new ActiveXObject('Msxml2.XMLHTTP');}
function nj(){}
_=nj.prototype=new mj();_.t=qj;_.tN=fC+'HTTPRequestImplIE6';_.tI=0;function Aj(a){tv(a,'This application is out of date, please click the refresh button on your browser');return a;}
function zj(){}
_=zj.prototype=new sv();_.tN=gC+'IncompatibleRemoteServiceException';_.tI=22;function Ej(b,a){}
function Fj(b,a){}
function bk(b,a){uv(b,a,null);return b;}
function ak(){}
_=ak.prototype=new sv();_.tN=gC+'InvocationException';_.tI=23;function fk(b,a){fu(b,a);return b;}
function ek(){}
_=ek.prototype=new eu();_.tN=gC+'SerializationException';_.tI=24;function kk(a){bk(a,'Service implementation URL not specified');return a;}
function jk(){}
_=jk.prototype=new ak();_.tN=gC+'ServiceDefTarget$NoServiceEntryPointSpecifiedException';_.tI=25;function pk(b,a){}
function qk(a){return su(new ru(),a.rb());}
function rk(b,a){b.Db(a.a);}
function uk(b,a){}
function vk(a){return a.tb();}
function wk(b,a){b.Fb(a);}
function zk(e,b){var a,c,d;d=e.rb();for(a=0;a<d;++a){c=e.sb();cz(b,c);}}
function Ak(e,a){var b,c,d;d=a.b;e.Db(d);b=a.ab();while(b.F()){c=b.cb();e.Eb(c);}}
function Dk(e,b){var a,c,d;d=e.rb();for(a=0;a<d;++a){c=e.sb();vB(b,c);}}
function Ek(e,a){var b,c,d;d=a.a.b;e.Db(d);b=xB(a);while(b.F()){c=b.cb();e.Eb(c);}}
function sl(a){return a.j>2;}
function tl(b,a){b.i=a;}
function ul(a,b){a.j=b;}
function Fk(){}
_=Fk.prototype=new ov();_.tN=jC+'AbstractSerializationStream';_.tI=0;_.i=0;_.j=3;function bl(a){a.e=az(new Ey());}
function cl(a){bl(a);return a;}
function el(b,a){ez(b.e);ul(b,Al(b));tl(b,Al(b));}
function fl(a){var b,c;b=a.rb();if(b<0){return hz(a.e,-(b+1));}c=a.B(b);if(c===null){return null;}return a.r(c);}
function gl(b,a){cz(b.e,a);}
function hl(){return fl(this);}
function al(){}
_=al.prototype=new Fk();_.sb=hl;_.tN=jC+'AbstractSerializationStreamReader';_.tI=0;function kl(b,a){b.o(qw(a));}
function ll(c,a){var b,d;if(a===null){ml(c,null);return;}b=c.y(a);if(b>=0){kl(c,-(b+1));return;}c.yb(a);d=c.A(a);ml(c,d);c.zb(a,d);}
function ml(a,b){kl(a,a.l(b));}
function nl(a){this.o(pw(a));}
function ol(a){kl(this,a);}
function pl(a){ll(this,a);}
function ql(a){ml(this,a);}
function il(){}
_=il.prototype=new Fk();_.Cb=nl;_.Db=ol;_.Eb=pl;_.Fb=ql;_.tN=jC+'AbstractSerializationStreamWriter';_.tI=0;function wl(b,a){cl(b);b.c=a;return b;}
function yl(b,a){if(!a){return null;}return b.d[a-1];}
function zl(b,a){b.b=Dl(a);b.a=El(b.b);el(b,a);b.d=Bl(b);}
function Al(a){return a.b[--a.a];}
function Bl(a){return a.b[--a.a];}
function Cl(b){var a;a=jc(this.c,this,b);gl(this,a);hc(this.c,this,a,b);return a;}
function Dl(a){return eval(a);}
function El(a){return a.length;}
function Fl(a){return yl(this,a);}
function am(){return this.b[--this.a];}
function bm(){return Al(this);}
function cm(){return yl(this,Al(this));}
function vl(){}
_=vl.prototype=new al();_.r=Cl;_.B=Fl;_.qb=am;_.rb=bm;_.tb=cm;_.tN=jC+'ClientSerializationStreamReader';_.tI=0;_.a=0;_.b=null;_.c=null;_.d=null;function em(a){a.h=az(new Ey());}
function fm(d,c,a,b){em(d);d.f=c;d.b=a;d.e=b;return d;}
function hm(c,a){var b=c.d[a];return b==null?-1:b;}
function im(c,a){var b=c.g[':'+a];return b==null?0:b;}
function jm(a){a.c=0;a.d=kd();a.g=kd();ez(a.h);a.a=yv(new xv());if(sl(a)){ml(a,a.b);ml(a,a.e);}}
function km(b,a,c){b.d[a]=c;}
function lm(b,a,c){b.g[':'+a]=c;}
function mm(b){var a;a=yv(new xv());nm(b,a);pm(b,a);om(b,a);return Ev(a);}
function nm(b,a){rm(a,qw(b.j));rm(a,qw(b.i));}
function om(b,a){Av(a,Ev(b.a));}
function pm(d,a){var b,c;c=d.h.b;rm(a,qw(c));for(b=0;b<c;++b){rm(a,Bd(hz(d.h,b),1));}return a;}
function qm(b){var a;if(b===null){return 0;}a=im(this,b);if(a>0){return a;}cz(this.h,b);a=this.h.b;lm(this,b,a);return a;}
function rm(a,b){Av(a,b);zv(a,65535);}
function sm(a){rm(this.a,a);}
function tm(a){return hm(this,uw(a));}
function um(a){var b,c;c=yc(a);b=ic(this.f,c);if(b!==null){c+='/'+b;}return c;}
function vm(a){km(this,uw(a),this.c++);}
function wm(a,b){kc(this.f,this,a,b);}
function dm(){}
_=dm.prototype=new il();_.l=qm;_.o=sm;_.y=tm;_.A=um;_.yb=vm;_.zb=wm;_.tN=jC+'ClientSerializationStreamWriter';_.tI=0;_.a=null;_.b=null;_.c=0;_.d=null;_.e=null;_.f=null;_.g=null;function Dr(b,a){Er(b,as(b)+Ad(45)+a);}
function Er(b,a){ls(b.i,a,true);}
function as(a){return js(a.i);}
function bs(b,a){cs(b,as(b)+Ad(45)+a);}
function cs(b,a){ls(b.i,a,false);}
function ds(d,b,a){var c=b.parentNode;if(!c){return;}c.insertBefore(a,b);c.removeChild(b);}
function es(b,a){if(b.i!==null){ds(b,b.i,a);}b.i=a;}
function fs(b,a){ks(b.i,a);}
function gs(a,b){tg(a.i,'width',b);}
function hs(b,a){ug(b.i,a|fg(b.i));}
function is(a){return eg(a,'className');}
function js(a){var b,c;b=is(a);c=cw(b,32);if(c>=0){return iw(b,0,c);}return b;}
function ks(a,b){pg(a,'className',b);}
function ls(c,j,a){var b,d,e,f,g,h,i;if(c===null){throw tv(new sv(),'Null widget handle. If you are creating a composite, ensure that initWidget() has been called.');}j=jw(j);if(fw(j)==0){throw ju(new iu(),'Style names cannot be empty');}i=is(c);e=dw(i,j);while(e!=(-1)){if(e==0||aw(i,e-1)==32){f=e+fw(j);g=fw(i);if(f==g||f<g&&aw(i,f)==32){break;}}e=ew(i,j,e+1);}if(a){if(e==(-1)){if(fw(i)>0){i+=' ';}pg(c,'className',i+j);}}else{if(e!=(-1)){b=jw(iw(i,0,e));d=jw(hw(i,e+fw(j)));if(fw(b)==0){h=d;}else if(fw(d)==0){h=b;}else{h=b+' '+d;}pg(c,'className',h);}}}
function Cr(){}
_=Cr.prototype=new ov();_.tN=kC+'UIObject';_.tI=0;_.i=null;function gt(a){if(a.g){throw mu(new lu(),"Should only call onAttach when the widget is detached from the browser's document");}a.g=true;qg(a.i,a);a.s();a.lb();}
function ht(a){if(!a.g){throw mu(new lu(),"Should only call onDetach when the widget is attached to the browser's document");}try{a.mb();}finally{a.u();qg(a.i,null);a.g=false;}}
function it(a){if(a.h!==null){a.h.wb(a);}else if(a.h!==null){throw mu(new lu(),"This widget's parent does not implement HasWidgets");}}
function jt(b,a){if(b.g){qg(b.i,null);}es(b,a);if(b.g){qg(a,b);}}
function kt(c,b){var a;a=c.h;if(b===null){if(a!==null&&a.g){ht(c);}c.h=null;}else{if(a!==null){throw mu(new lu(),'Cannot set a new parent without first clearing the old parent');}c.h=b;if(b.g){gt(c);}}}
function lt(){}
function mt(){}
function nt(a){}
function ot(){}
function pt(){}
function qt(a){jt(this,a);}
function ts(){}
_=ts.prototype=new Cr();_.s=lt;_.u=mt;_.eb=nt;_.lb=ot;_.mb=pt;_.Ab=qt;_.tN=kC+'Widget';_.tI=26;_.g=false;_.h=null;function uq(b,a){kt(a,b);}
function wq(b,a){kt(a,null);}
function xq(){var a,b;for(b=this.ab();ys(b);){a=zs(b);gt(a);}}
function yq(){var a,b;for(b=this.ab();ys(b);){a=zs(b);ht(a);}}
function zq(){}
function Aq(){}
function tq(){}
_=tq.prototype=new ts();_.s=xq;_.u=yq;_.lb=zq;_.mb=Aq;_.tN=kC+'Panel';_.tI=27;function An(a){a.f=Ds(new us(),a);}
function Bn(a){An(a);return a;}
function Cn(c,a,b){it(a);Es(c.f,a);of(b,a.i);uq(c,a);}
function En(b,c){var a;if(c.h!==b){return false;}wq(b,c);a=c.i;kg(gg(a),a);et(b.f,c);return true;}
function Fn(){return ct(this.f);}
function ao(a){return En(this,a);}
function zn(){}
_=zn.prototype=new tq();_.ab=Fn;_.wb=ao;_.tN=kC+'ComplexPanel';_.tI=28;function zm(a){Bn(a);a.Ab(rf());tg(a.i,'position','relative');tg(a.i,'overflow','hidden');return a;}
function Am(a,b){Cn(a,b,a.i);}
function Cm(a){tg(a,'left','');tg(a,'top','');tg(a,'position','');}
function Dm(b){var a;a=En(this,b);if(a){Cm(b.i);}return a;}
function ym(){}
_=ym.prototype=new zn();_.wb=Dm;_.tN=kC+'AbsolutePanel';_.tI=29;function eo(){eo=FB;wt(),yt;}
function co(b,a){wt(),yt;go(b,a);return b;}
function fo(b,a){switch(bg(a)){case 1:if(b.d!==null){xn(b.d,b);}break;case 4096:case 2048:break;case 128:case 512:case 256:break;}}
function go(b,a){jt(b,a);hs(b,7041);}
function ho(b,a){ng(b.i,'disabled',!a);}
function io(a){if(this.d===null){this.d=vn(new un());}cz(this.d,a);}
function jo(a){fo(this,a);}
function ko(a){go(this,a);}
function bo(){}
_=bo.prototype=new ts();_.k=io;_.eb=jo;_.Ab=ko;_.tN=kC+'FocusWidget';_.tI=30;_.d=null;function bn(){bn=FB;wt(),yt;}
function an(b,a){wt(),yt;co(b,a);return b;}
function cn(b,a){rg(b.i,a);}
function Fm(){}
_=Fm.prototype=new bo();_.tN=kC+'ButtonBase';_.tI=31;function fn(){fn=FB;wt(),yt;}
function dn(a){wt(),yt;an(a,qf());gn(a.i);fs(a,'gwt-Button');return a;}
function en(b,a){wt(),yt;dn(b);cn(b,a);return b;}
function gn(b){fn();if(b.type=='submit'){try{b.setAttribute('type','button');}catch(a){}}}
function Em(){}
_=Em.prototype=new Fm();_.tN=kC+'Button';_.tI=32;function jn(a){Bn(a);a.e=wf();a.d=tf();of(a.e,a.d);a.Ab(a.e);return a;}
function ln(a,b){if(b.h!==a){return null;}return gg(b.i);}
function nn(c,d,a){var b;b=ln(c,d);if(b!==null){mn(c,b,a);}}
function mn(c,b,a){pg(b,'align',a.a);}
function on(c,b,a){tg(b,'verticalAlign',a.a);}
function hn(){}
_=hn.prototype=new zn();_.tN=kC+'CellPanel';_.tI=33;_.d=null;_.e=null;function Dw(d,a,b){var c;while(a.F()){c=a.cb();if(b===null?c===null:b.eQ(c)){return a;}}return null;}
function Fw(a){throw Aw(new zw(),'add');}
function ax(b){var a;a=Dw(this,this.ab(),b);return a!==null;}
function Cw(){}
_=Cw.prototype=new ov();_.n=Fw;_.q=ax;_.tN=nC+'AbstractCollection';_.tI=0;function kx(b,a){throw pu(new ou(),'Index: '+a+', Size: '+b.b);}
function lx(b,a){throw Aw(new zw(),'add');}
function mx(a){this.m(this.Bb(),a);return true;}
function nx(e){var a,b,c,d,f;if(e===this){return true;}if(!Cd(e,2)){return false;}f=Bd(e,2);if(this.Bb()!=f.Bb()){return false;}c=this.ab();d=f.ab();while(c.F()){a=c.cb();b=d.cb();if(!(a===null?b===null:a.eQ(b))){return false;}}return true;}
function ox(){var a,b,c,d;c=1;a=31;b=this.ab();while(b.F()){d=b.cb();c=31*c+(d===null?0:d.hC());}return c;}
function px(){return dx(new cx(),this);}
function qx(a){throw Aw(new zw(),'remove');}
function bx(){}
_=bx.prototype=new Cw();_.m=lx;_.n=mx;_.eQ=nx;_.hC=ox;_.ab=px;_.vb=qx;_.tN=nC+'AbstractList';_.tI=34;function Fy(a){{dz(a);}}
function az(a){Fy(a);return a;}
function bz(c,a,b){if(a<0||a>c.b){kx(c,a);}nz(c.a,a,b);++c.b;}
function cz(b,a){wz(b.a,b.b++,a);return true;}
function ez(a){dz(a);}
function dz(a){a.a=id();a.b=0;}
function gz(b,a){return iz(b,a)!=(-1);}
function hz(b,a){if(a<0||a>=b.b){kx(b,a);}return sz(b.a,a);}
function iz(b,a){return jz(b,a,0);}
function jz(c,b,a){if(a<0){kx(c,a);}for(;a<c.b;++a){if(rz(b,sz(c.a,a))){return a;}}return (-1);}
function kz(a){return a.b==0;}
function lz(c,a){var b;b=hz(c,a);uz(c.a,a,1);--c.b;return b;}
function mz(c,b){var a;a=iz(c,b);if(a==(-1)){return false;}lz(c,a);return true;}
function oz(a,b){bz(this,a,b);}
function pz(a){return cz(this,a);}
function nz(a,b,c){a.splice(b,0,c);}
function qz(a){return gz(this,a);}
function rz(a,b){return a===b||a!==null&&a.eQ(b);}
function tz(a){return hz(this,a);}
function sz(a,b){return a[b];}
function vz(a){return lz(this,a);}
function uz(a,c,b){a.splice(c,b);}
function wz(a,b,c){a[b]=c;}
function xz(){return this.b;}
function Ey(){}
_=Ey.prototype=new bx();_.m=oz;_.n=pz;_.q=qz;_.D=tz;_.vb=vz;_.Bb=xz;_.tN=nC+'ArrayList';_.tI=35;_.a=null;_.b=0;function qn(a){az(a);return a;}
function sn(d,c){var a,b;for(a=d.ab();a.F();){b=Bd(a.cb(),12);b.fb(c);}}
function pn(){}
_=pn.prototype=new Ey();_.tN=kC+'ChangeListenerCollection';_.tI=36;function vn(a){az(a);return a;}
function xn(d,c){var a,b;for(a=d.ab();a.F();){b=Bd(a.cb(),13);b.gb(c);}}
function un(){}
_=un.prototype=new Ey();_.tN=kC+'ClickListenerCollection';_.tI=37;function zp(a){a.Ab(rf());hs(a,131197);fs(a,'gwt-Label');return a;}
function Ap(b,a){zp(b);Cp(b,a);return b;}
function Cp(b,a){sg(b.i,a);}
function Dp(a){switch(bg(a)){case 1:break;case 4:case 8:case 64:case 16:case 32:break;case 131072:break;}}
function yp(){}
_=yp.prototype=new ts();_.eb=Dp;_.tN=kC+'Label';_.tI=38;function mo(a){zp(a);a.Ab(rf());hs(a,125);fs(a,'gwt-HTML');return a;}
function no(b,a){mo(b);po(b,a);return b;}
function po(b,a){rg(b.i,a);}
function lo(){}
_=lo.prototype=new yp();_.tN=kC+'HTML';_.tI=39;function wo(){wo=FB;uo(new to(),'center');xo=uo(new to(),'left');yo=uo(new to(),'right');}
var xo,yo;function uo(b,a){b.a=a;return b;}
function to(){}
_=to.prototype=new ov();_.tN=kC+'HasHorizontalAlignment$HorizontalAlignmentConstant';_.tI=0;_.a=null;function Eo(){Eo=FB;Co(new Bo(),'bottom');Co(new Bo(),'middle');Fo=Co(new Bo(),'top');}
var Fo;function Co(a,b){a.a=b;return a;}
function Bo(){}
_=Bo.prototype=new ov();_.tN=kC+'HasVerticalAlignment$VerticalAlignmentConstant';_.tI=0;_.a=null;function dp(a){a.a=(wo(),xo);a.c=(Eo(),Fo);}
function ep(a){jn(a);dp(a);a.b=vf();of(a.d,a.b);pg(a.e,'cellSpacing','0');pg(a.e,'cellPadding','0');return a;}
function fp(b,c){var a;a=hp(b);of(b.b,a);Cn(b,c,a);}
function hp(b){var a;a=uf();mn(b,a,b.a);on(b,a,b.c);return a;}
function ip(c){var a,b;b=gg(c.i);a=En(this,c);if(a){kg(this.b,b);}return a;}
function cp(){}
_=cp.prototype=new hn();_.wb=ip;_.tN=kC+'HorizontalPanel';_.tI=40;_.b=null;function qp(a){az(a);return a;}
function sp(f,e,b,d){var a,c;for(a=f.ab();a.F();){c=Bd(a.cb(),14);c.ib(e,b,d);}}
function tp(f,e,b,d){var a,c;for(a=f.ab();a.F();){c=Bd(a.cb(),14);c.jb(e,b,d);}}
function up(f,e,b,d){var a,c;for(a=f.ab();a.F();){c=Bd(a.cb(),14);c.kb(e,b,d);}}
function vp(d,c,a){var b;b=wp(a);switch(bg(a)){case 128:sp(d,c,Dd(Ef(a)),b);break;case 512:up(d,c,Dd(Ef(a)),b);break;case 256:tp(d,c,Dd(Ef(a)),b);break;}}
function wp(a){return (ag(a)?1:0)|(Ff(a)?8:0)|(Df(a)?2:0)|(Cf(a)?4:0);}
function pp(){}
_=pp.prototype=new Ey();_.tN=kC+'KeyboardListenerCollection';_.tI=41;function iq(){iq=FB;wt(),yt;rq=new Fp();}
function eq(a){iq();fq(a,false);return a;}
function fq(b,a){iq();co(b,sf(a));hs(b,1024);fs(b,'gwt-ListBox');return b;}
function gq(b,a){mq(b,a,(-1));}
function hq(b,a){if(a<0||a>=jq(b)){throw new ou();}}
function jq(a){return bq(rq,a.i);}
function kq(a){return dg(a.i,'selectedIndex');}
function lq(b,a){hq(b,a);return cq(rq,b.i,a);}
function mq(c,b,a){nq(c,b,b,a);}
function nq(c,b,d,a){ig(c.i,b,d,a);}
function oq(c,a,b){hq(c,a);dq(rq,c.i,a,b);}
function pq(b,a){ng(b.i,'multiple',a);}
function qq(a,b){og(a.i,'size',b);}
function sq(a){if(bg(a)==1024){}else{fo(this,a);}}
function Ep(){}
_=Ep.prototype=new bo();_.eb=sq;_.tN=kC+'ListBox';_.tI=42;var rq;function bq(b,a){return a.options.length;}
function cq(c,b,a){return b.options[a].value;}
function dq(d,b,a,c){b.options[a].selected=c;}
function Fp(){}
_=Fp.prototype=new ov();_.tN=kC+'ListBox$Impl';_.tI=0;function br(){br=FB;gr=uA(new Az());}
function ar(b,a){br();zm(b);if(a===null){a=cr();}b.Ab(a);gt(b);return b;}
function dr(){br();return er(null);}
function er(c){br();var a,b;b=Bd(AA(gr,c),15);if(b!==null){return b;}a=null;if(gr.c==0){fr();}BA(gr,c,b=ar(new Bq(),a));return b;}
function cr(){br();return $doc.body;}
function fr(){br();Dh(new Cq());}
function Bq(){}
_=Bq.prototype=new ym();_.tN=kC+'RootPanel';_.tI=43;var gr;function Eq(){var a,b;for(b=ey(ty((br(),gr)));ly(b);){a=Bd(my(b),15);if(a.g){ht(a);}}}
function Fq(){return null;}
function Cq(){}
_=Cq.prototype=new ov();_.nb=Eq;_.ob=Fq;_.tN=kC+'RootPanel$1';_.tI=44;function wr(){wr=FB;wt(),yt;}
function tr(b,a){wt(),yt;co(b,a);hs(b,1024);return b;}
function ur(b,a){if(b.a===null){b.a=qn(new pn());}cz(b.a,a);}
function vr(b,a){if(b.c===null){b.c=qp(new pp());}cz(b.c,a);}
function xr(a){return eg(a.i,'value');}
function yr(c,a){var b;ng(c.i,'readOnly',a);b='readonly';if(a){Dr(c,b);}else{bs(c,b);}}
function zr(b,a){pg(b.i,'value',a!==null?a:'');}
function Ar(a){if(this.b===null){this.b=vn(new un());}cz(this.b,a);}
function Br(a){var b;fo(this,a);b=bg(a);if(this.c!==null&&(b&896)!=0){vp(this.c,this,a);}else if(b==1){if(this.b!==null){xn(this.b,this);}}else if(b==1024){if(this.a!==null){sn(this.a,this);}}}
function sr(){}
_=sr.prototype=new bo();_.k=Ar;_.eb=Br;_.tN=kC+'TextBoxBase';_.tI=45;_.a=null;_.b=null;_.c=null;function pr(){pr=FB;wt(),yt;}
function or(a){wt(),yt;tr(a,xf());fs(a,'gwt-TextArea');return a;}
function qr(a,b){og(a.i,'cols',b);}
function rr(b,a){og(b.i,'rows',a);}
function nr(){}
_=nr.prototype=new sr();_.tN=kC+'TextArea';_.tI=46;function ns(a){a.a=(wo(),xo);a.b=(Eo(),Fo);}
function os(a){jn(a);ns(a);pg(a.e,'cellSpacing','0');pg(a.e,'cellPadding','0');return a;}
function ps(b,d){var a,c;c=vf();a=rs(b);of(c,a);of(b.d,c);Cn(b,d,a);}
function rs(b){var a;a=uf();mn(b,a,b.a);on(b,a,b.b);return a;}
function ss(c){var a,b;b=gg(c.i);a=En(this,c);if(a){kg(this.d,gg(b));}return a;}
function ms(){}
_=ms.prototype=new hn();_.wb=ss;_.tN=kC+'VerticalPanel';_.tI=47;function Ds(b,a){b.b=a;b.a=vd('[Lcom.google.gwt.user.client.ui.Widget;',[0],[17],[4],null);return b;}
function Es(a,b){bt(a,b,a.c);}
function at(b,c){var a;for(a=0;a<b.c;++a){if(b.a[a]===c){return a;}}return (-1);}
function bt(d,e,a){var b,c;if(a<0||a>d.c){throw new ou();}if(d.c==d.a.a){c=vd('[Lcom.google.gwt.user.client.ui.Widget;',[0],[17],[d.a.a*2],null);for(b=0;b<d.a.a;++b){wd(c,b,d.a[b]);}d.a=c;}++d.c;for(b=d.c-1;b>a;--b){wd(d.a,b,d.a[b-1]);}wd(d.a,a,e);}
function ct(a){return ws(new vs(),a);}
function dt(c,b){var a;if(b<0||b>=c.c){throw new ou();}--c.c;for(a=b;a<c.c;++a){wd(c.a,a,c.a[a+1]);}wd(c.a,c.c,null);}
function et(b,c){var a;a=at(b,c);if(a==(-1)){throw new pB();}dt(b,a);}
function us(){}
_=us.prototype=new ov();_.tN=kC+'WidgetCollection';_.tI=0;_.a=null;_.b=null;_.c=0;function ws(b,a){b.b=a;return b;}
function ys(a){return a.a<a.b.c-1;}
function zs(a){if(a.a>=a.b.c){throw new pB();}return a.b.a[++a.a];}
function As(){return ys(this);}
function Bs(){return zs(this);}
function Cs(){if(this.a<0||this.a>=this.b.c){throw new lu();}this.b.b.wb(this.b.a[this.a--]);}
function vs(){}
_=vs.prototype=new ov();_.F=As;_.cb=Bs;_.ub=Cs;_.tN=kC+'WidgetCollection$WidgetIterator';_.tI=0;_.a=(-1);function wt(){wt=FB;xt=tt(new st());yt=xt;}
function vt(a){wt();return a;}
function rt(){}
_=rt.prototype=new ov();_.tN=lC+'FocusImpl';_.tI=0;var xt,yt;function ut(){ut=FB;wt();}
function tt(a){ut();vt(a);return a;}
function st(){}
_=st.prototype=new rt();_.tN=lC+'FocusImplIE6';_.tI=0;function At(){}
_=At.prototype=new sv();_.tN=mC+'ArrayStoreException';_.tI=48;function Ft(a,b){if(b<2||b>36){return (-1);}if(a>=48&&a<48+Du(b,10)){return a-48;}if(a>=97&&a<b+97-10){return a-97+10;}if(a>=65&&a<b+65-10){return a-65+10;}return (-1);}
function au(){}
_=au.prototype=new sv();_.tN=mC+'ClassCastException';_.tI=49;function ju(b,a){tv(b,a);return b;}
function iu(){}
_=iu.prototype=new sv();_.tN=mC+'IllegalArgumentException';_.tI=50;function mu(b,a){tv(b,a);return b;}
function lu(){}
_=lu.prototype=new sv();_.tN=mC+'IllegalStateException';_.tI=51;function pu(b,a){tv(b,a);return b;}
function ou(){}
_=ou.prototype=new sv();_.tN=mC+'IndexOutOfBoundsException';_.tI=52;function iv(){iv=FB;{nv();}}
function hv(a){iv();return a;}
function jv(a){iv();return isNaN(a);}
function kv(e,d,c,h){iv();var a,b,f,g;if(e===null){throw fv(new ev(),'Unable to parse null');}b=fw(e);f=b>0&&aw(e,0)==45?1:0;for(a=f;a<b;a++){if(Ft(aw(e,a),d)==(-1)){throw fv(new ev(),'Could not parse '+e+' in radix '+d);}}g=lv(e,d);if(jv(g)){throw fv(new ev(),'Unable to parse '+e);}else if(g<c||g>h){throw fv(new ev(),'The string '+e+' exceeds the range for the requested data type');}return g;}
function lv(b,a){iv();return parseInt(b,a);}
function nv(){iv();mv=/^[+-]?\d*\.?\d*(e[+-]?\d+)?$/i;}
function dv(){}
_=dv.prototype=new ov();_.tN=mC+'Number';_.tI=0;var mv=null;function tu(){tu=FB;iv();}
function su(a,b){tu();hv(a);a.a=b;return a;}
function uu(a){return Cd(a,20)&&Bd(a,20).a==this.a;}
function vu(){return this.a;}
function wu(a){tu();return xu(a,10);}
function xu(b,a){tu();return Ed(kv(b,a,(-2147483648),2147483647));}
function yu(a){tu();return qw(a);}
function zu(a){tu();return su(new ru(),wu(a));}
function ru(){}
_=ru.prototype=new dv();_.eQ=uu;_.hC=vu;_.tN=mC+'Integer';_.tI=53;_.a=0;function Cu(a){return a<0?-a:a;}
function Du(a,b){return a<b?a:b;}
function Eu(){}
_=Eu.prototype=new sv();_.tN=mC+'NegativeArraySizeException';_.tI=54;function bv(b,a){tv(b,a);return b;}
function av(){}
_=av.prototype=new sv();_.tN=mC+'NullPointerException';_.tI=55;function fv(b,a){ju(b,a);return b;}
function ev(){}
_=ev.prototype=new iu();_.tN=mC+'NumberFormatException';_.tI=56;function aw(b,a){return b.charCodeAt(a);}
function cw(b,a){return b.indexOf(String.fromCharCode(a));}
function dw(b,a){return b.indexOf(a);}
function ew(c,b,a){return c.indexOf(b,a);}
function fw(a){return a.length;}
function gw(b,a){return dw(b,a)==0;}
function hw(b,a){return b.substr(a,b.length-a);}
function iw(c,a,b){return c.substr(a,b-a);}
function jw(c){var a=c.replace(/^(\s*)/,'');var b=a.replace(/\s*$/,'');return b;}
function kw(a,b){return String(a)==b;}
function lw(a){if(!Cd(a,1))return false;return kw(this,a);}
function nw(){var a=mw;if(!a){a=mw={};}var e=':'+this;var b=a[e];if(b==null){b=0;var f=this.length;var d=f<64?1:f/32|0;for(var c=0;c<f;c+=d){b<<=1;b+=this.charCodeAt(c);}b|=0;a[e]=b;}return b;}
function ow(a){return String.fromCharCode(a);}
function pw(a){return ''+a;}
function qw(a){return ''+a;}
_=String.prototype;_.eQ=lw;_.hC=nw;_.tN=mC+'String';_.tI=2;var mw=null;function yv(a){Bv(a);return a;}
function zv(a,b){return Av(a,ow(b));}
function Av(c,d){if(d===null){d='null';}var a=c.js.length-1;var b=c.js[a].length;if(c.length>b*b){c.js[a]=c.js[a]+d;}else{c.js.push(d);}c.length+=d.length;return c;}
function Bv(a){Cv(a,'');}
function Cv(b,a){b.js=[a];b.length=a.length;}
function Ev(a){a.db();return a.js[0];}
function Fv(){if(this.js.length>1){this.js=[this.js.join('')];this.length=this.js[0].length;}}
function xv(){}
_=xv.prototype=new ov();_.db=Fv;_.tN=mC+'StringBuffer';_.tI=0;function tw(){return new Date().getTime();}
function uw(a){return Dc(a);}
function Aw(b,a){tv(b,a);return b;}
function zw(){}
_=zw.prototype=new sv();_.tN=mC+'UnsupportedOperationException';_.tI=57;function dx(b,a){b.c=a;return b;}
function fx(a){return a.a<a.c.Bb();}
function gx(){return fx(this);}
function hx(){if(!fx(this)){throw new pB();}return this.c.D(this.b=this.a++);}
function ix(){if(this.b<0){throw new lu();}this.c.vb(this.b);this.a=this.b;this.b=(-1);}
function cx(){}
_=cx.prototype=new ov();_.F=gx;_.cb=hx;_.ub=ix;_.tN=nC+'AbstractList$IteratorImpl';_.tI=0;_.a=0;_.b=(-1);function ry(f,d,e){var a,b,c;for(b=pA(f.v());hA(b);){a=iA(b);c=a.z();if(d===null?c===null:d.eQ(c)){if(e){jA(b);}return a;}}return null;}
function sy(b){var a;a=b.v();return tx(new sx(),b,a);}
function ty(b){var a;a=zA(b);return cy(new by(),b,a);}
function uy(a){return ry(this,a,false)!==null;}
function vy(d){var a,b,c,e,f,g,h;if(d===this){return true;}if(!Cd(d,21)){return false;}f=Bd(d,21);c=sy(this);e=f.bb();if(!By(c,e)){return false;}for(a=vx(c);Cx(a);){b=Dx(a);h=this.E(b);g=f.E(b);if(h===null?g!==null:!h.eQ(g)){return false;}}return true;}
function wy(b){var a;a=ry(this,b,false);return a===null?null:a.C();}
function xy(){var a,b,c;b=0;for(c=pA(this.v());hA(c);){a=iA(c);b+=a.hC();}return b;}
function yy(){return sy(this);}
function rx(){}
_=rx.prototype=new ov();_.p=uy;_.eQ=vy;_.E=wy;_.hC=xy;_.bb=yy;_.tN=nC+'AbstractMap';_.tI=58;function By(e,b){var a,c,d;if(b===e){return true;}if(!Cd(b,22)){return false;}c=Bd(b,22);if(c.Bb()!=e.Bb()){return false;}for(a=c.ab();a.F();){d=a.cb();if(!e.q(d)){return false;}}return true;}
function Cy(a){return By(this,a);}
function Dy(){var a,b,c;a=0;for(b=this.ab();b.F();){c=b.cb();if(c!==null){a+=c.hC();}}return a;}
function zy(){}
_=zy.prototype=new Cw();_.eQ=Cy;_.hC=Dy;_.tN=nC+'AbstractSet';_.tI=59;function tx(b,a,c){b.a=a;b.b=c;return b;}
function vx(b){var a;a=pA(b.b);return Ax(new zx(),b,a);}
function wx(a){return this.a.p(a);}
function xx(){return vx(this);}
function yx(){return this.b.a.c;}
function sx(){}
_=sx.prototype=new zy();_.q=wx;_.ab=xx;_.Bb=yx;_.tN=nC+'AbstractMap$1';_.tI=60;function Ax(b,a,c){b.a=c;return b;}
function Cx(a){return hA(a.a);}
function Dx(b){var a;a=iA(b.a);return a.z();}
function Ex(){return Cx(this);}
function Fx(){return Dx(this);}
function ay(){jA(this.a);}
function zx(){}
_=zx.prototype=new ov();_.F=Ex;_.cb=Fx;_.ub=ay;_.tN=nC+'AbstractMap$2';_.tI=0;function cy(b,a,c){b.a=a;b.b=c;return b;}
function ey(b){var a;a=pA(b.b);return jy(new iy(),b,a);}
function fy(a){return yA(this.a,a);}
function gy(){return ey(this);}
function hy(){return this.b.a.c;}
function by(){}
_=by.prototype=new Cw();_.q=fy;_.ab=gy;_.Bb=hy;_.tN=nC+'AbstractMap$3';_.tI=0;function jy(b,a,c){b.a=c;return b;}
function ly(a){return hA(a.a);}
function my(a){var b;b=iA(a.a).C();return b;}
function ny(){return ly(this);}
function oy(){return my(this);}
function py(){jA(this.a);}
function iy(){}
_=iy.prototype=new ov();_.F=ny;_.cb=oy;_.ub=py;_.tN=nC+'AbstractMap$4';_.tI=0;function wA(){wA=FB;DA=dB();}
function tA(a){{vA(a);}}
function uA(a){wA();tA(a);return a;}
function vA(a){a.a=id();a.d=kd();a.b=ce(DA,ed);a.c=0;}
function xA(b,a){if(Cd(a,1)){return hB(b.d,Bd(a,1))!==DA;}else if(a===null){return b.b!==DA;}else{return gB(b.a,a,a.hC())!==DA;}}
function yA(a,b){if(a.b!==DA&&fB(a.b,b)){return true;}else if(cB(a.d,b)){return true;}else if(aB(a.a,b)){return true;}return false;}
function zA(a){return nA(new dA(),a);}
function AA(c,a){var b;if(Cd(a,1)){b=hB(c.d,Bd(a,1));}else if(a===null){b=c.b;}else{b=gB(c.a,a,a.hC());}return b===DA?null:b;}
function BA(c,a,d){var b;{b=c.b;c.b=d;}if(b===DA){++c.c;return null;}else{return b;}}
function CA(c,a){var b;if(Cd(a,1)){b=kB(c.d,Bd(a,1));}else if(a===null){b=c.b;c.b=ce(DA,ed);}else{b=jB(c.a,a,a.hC());}if(b===DA){return null;}else{--c.c;return b;}}
function EA(e,c){wA();for(var d in e){if(d==parseInt(d)){var a=e[d];for(var f=0,b=a.length;f<b;++f){c.n(a[f]);}}}}
function FA(d,a){wA();for(var c in d){if(c.charCodeAt(0)==58){var e=d[c];var b=Ez(c.substring(1),e);a.n(b);}}}
function aB(f,h){wA();for(var e in f){if(e==parseInt(e)){var a=f[e];for(var g=0,b=a.length;g<b;++g){var c=a[g];var d=c.C();if(fB(h,d)){return true;}}}}return false;}
function bB(a){return xA(this,a);}
function cB(c,d){wA();for(var b in c){if(b.charCodeAt(0)==58){var a=c[b];if(fB(d,a)){return true;}}}return false;}
function dB(){wA();}
function eB(){return zA(this);}
function fB(a,b){wA();if(a===b){return true;}else if(a===null){return false;}else{return a.eQ(b);}}
function iB(a){return AA(this,a);}
function gB(f,h,e){wA();var a=f[e];if(a){for(var g=0,b=a.length;g<b;++g){var c=a[g];var d=c.z();if(fB(h,d)){return c.C();}}}}
function hB(b,a){wA();return b[':'+a];}
function jB(f,h,e){wA();var a=f[e];if(a){for(var g=0,b=a.length;g<b;++g){var c=a[g];var d=c.z();if(fB(h,d)){if(a.length==1){delete f[e];}else{a.splice(g,1);}return c.C();}}}}
function kB(c,a){wA();a=':'+a;var b=c[a];delete c[a];return b;}
function Az(){}
_=Az.prototype=new rx();_.p=bB;_.v=eB;_.E=iB;_.tN=nC+'HashMap';_.tI=61;_.a=null;_.b=null;_.c=0;_.d=null;var DA;function Cz(b,a,c){b.a=a;b.b=c;return b;}
function Ez(a,b){return Cz(new Bz(),a,b);}
function Fz(b){var a;if(Cd(b,23)){a=Bd(b,23);if(fB(this.a,a.z())&&fB(this.b,a.C())){return true;}}return false;}
function aA(){return this.a;}
function bA(){return this.b;}
function cA(){var a,b;a=0;b=0;if(this.a!==null){a=this.a.hC();}if(this.b!==null){b=this.b.hC();}return a^b;}
function Bz(){}
_=Bz.prototype=new ov();_.eQ=Fz;_.z=aA;_.C=bA;_.hC=cA;_.tN=nC+'HashMap$EntryImpl';_.tI=62;_.a=null;_.b=null;function nA(b,a){b.a=a;return b;}
function pA(a){return fA(new eA(),a.a);}
function qA(c){var a,b,d;if(Cd(c,23)){a=Bd(c,23);b=a.z();if(xA(this.a,b)){d=AA(this.a,b);return fB(a.C(),d);}}return false;}
function rA(){return pA(this);}
function sA(){return this.a.c;}
function dA(){}
_=dA.prototype=new zy();_.q=qA;_.ab=rA;_.Bb=sA;_.tN=nC+'HashMap$EntrySet';_.tI=63;function fA(c,b){var a;c.c=b;a=az(new Ey());if(c.c.b!==(wA(),DA)){cz(a,Cz(new Bz(),null,c.c.b));}FA(c.c.d,a);EA(c.c.a,a);c.a=a.ab();return c;}
function hA(a){return a.a.F();}
function iA(a){return a.b=Bd(a.a.cb(),23);}
function jA(a){if(a.b===null){throw mu(new lu(),'Must call next() before remove().');}else{a.a.ub();CA(a.c,a.b.z());a.b=null;}}
function kA(){return hA(this);}
function lA(){return iA(this);}
function mA(){jA(this);}
function eA(){}
_=eA.prototype=new ov();_.F=kA;_.cb=lA;_.ub=mA;_.tN=nC+'HashMap$EntrySetIterator';_.tI=0;_.a=null;_.b=null;function pB(){}
_=pB.prototype=new sv();_.tN=nC+'NoSuchElementException';_.tI=64;function uB(a){a.a=az(new Ey());return a;}
function vB(b,a){return cz(b.a,a);}
function xB(a){return a.a.ab();}
function yB(a,b){bz(this.a,a,b);}
function zB(a){return vB(this,a);}
function AB(a){return gz(this.a,a);}
function BB(a){return hz(this.a,a);}
function CB(){return xB(this);}
function DB(a){return lz(this.a,a);}
function EB(){return this.a.b;}
function tB(){}
_=tB.prototype=new bx();_.m=yB;_.n=zB;_.q=AB;_.D=BB;_.ab=CB;_.vb=DB;_.Bb=EB;_.tN=nC+'Vector';_.tI=65;_.a=null;function zt(){vb(new ab());}
function gwtOnLoad(b,d,c){$moduleName=d;$moduleBase=c;if(b)try{zt();}catch(a){b(d);}else{zt();}}
var be=[{},{},{1:1},{3:1},{11:1},{7:1},{12:1},{14:1},{14:1},{13:1},{5:1},{5:1},{5:1},{5:1},{6:1},{5:1},{9:1},{9:1},{9:1},{6:1,8:1},{6:1},{10:1},{5:1},{5:1},{4:1,5:1},{5:1},{16:1,17:1,18:1,19:1},{16:1,17:1,18:1,19:1},{16:1,17:1,18:1,19:1},{16:1,17:1,18:1,19:1},{16:1,17:1,18:1,19:1},{16:1,17:1,18:1,19:1},{16:1,17:1,18:1,19:1},{16:1,17:1,18:1,19:1},{2:1},{2:1},{2:1},{2:1},{16:1,17:1,18:1,19:1},{16:1,17:1,18:1,19:1},{16:1,17:1,18:1,19:1},{2:1},{16:1,17:1,18:1,19:1},{15:1,16:1,17:1,18:1,19:1},{10:1},{16:1,17:1,18:1,19:1},{16:1,17:1,18:1,19:1},{16:1,17:1,18:1,19:1},{5:1},{5:1},{5:1},{5:1},{5:1},{20:1},{5:1},{5:1},{5:1},{5:1},{21:1},{22:1},{22:1},{21:1},{23:1},{22:1},{5:1},{2:1}];if (TFDSSummarizer) {  var __gwt_initHandlers = TFDSSummarizer.__gwt_initHandlers;  TFDSSummarizer.onScriptLoad(gwtOnLoad);}})();