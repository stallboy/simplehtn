// Generated from simplehtn\JSHOP2.g4 by ANTLR 4.9.2
package simplehtn;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class JSHOP2Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		IMMEDIATE=32, UNORDERED=33, WS=34, COMMENT=35, ID=36, OPID=37, VARID=38, 
		NUM=39;
	public static final int
		RULE_shop = 0, RULE_problem = 1, RULE_domain = 2, RULE_pde = 3, RULE_method = 4, 
		RULE_methodsub = 5, RULE_operator = 6, RULE_axiom = 7, RULE_axiomsub = 8, 
		RULE_deladd = 9, RULE_deladdele = 10, RULE_tasklist = 11, RULE_tasklistsub = 12, 
		RULE_taskatom = 13, RULE_lprecond = 14, RULE_compname = 15, RULE_lexp = 16, 
		RULE_latomlist = 17, RULE_latom = 18, RULE_funcname = 19, RULE_terml = 20, 
		RULE_term = 21;
	private static String[] makeRuleNames() {
		return new String[] {
			"shop", "problem", "domain", "pde", "method", "methodsub", "operator", 
			"axiom", "axiomsub", "deladd", "deladdele", "tasklist", "tasklistsub", 
			"taskatom", "lprecond", "compname", "lexp", "latomlist", "latom", "funcname", 
			"terml", "term"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "'defproblem'", "')'", "'defdomain'", "':method'", "':operator'", 
			"':-'", "'nil'", "':protection'", "'forall'", "':first'", "':sort-by'", 
			"'<'", "'>'", "'and'", "'or'", "'not'", "'imply'", "'assign'", "'call'", 
			"'/'", "'='", "'<='", "'member'", "'-'", "'>='", "'*'", "'!='", "'+'", 
			"'^'", "'.'", "':immediate'", "':unordered'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, "IMMEDIATE", "UNORDERED", 
			"WS", "COMMENT", "ID", "OPID", "VARID", "NUM"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "JSHOP2.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public JSHOP2Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ShopContext extends ParserRuleContext {
		public DomainContext domain() {
			return getRuleContext(DomainContext.class,0);
		}
		public ProblemContext problem() {
			return getRuleContext(ProblemContext.class,0);
		}
		public ShopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterShop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitShop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSHOP2Visitor ) return ((JSHOP2Visitor<? extends T>)visitor).visitShop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ShopContext shop() throws RecognitionException {
		ShopContext _localctx = new ShopContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_shop);
		try {
			setState(46);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(44);
				domain();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(45);
				problem();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProblemContext extends ParserRuleContext {
		public Token pn;
		public Token dn;
		public LatomlistContext state;
		public TasklistContext tl;
		public List<TerminalNode> ID() { return getTokens(JSHOP2Parser.ID); }
		public TerminalNode ID(int i) {
			return getToken(JSHOP2Parser.ID, i);
		}
		public LatomlistContext latomlist() {
			return getRuleContext(LatomlistContext.class,0);
		}
		public TasklistContext tasklist() {
			return getRuleContext(TasklistContext.class,0);
		}
		public ProblemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_problem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterProblem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitProblem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSHOP2Visitor ) return ((JSHOP2Visitor<? extends T>)visitor).visitProblem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProblemContext problem() throws RecognitionException {
		ProblemContext _localctx = new ProblemContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_problem);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			match(T__0);
			setState(49);
			match(T__1);
			setState(50);
			((ProblemContext)_localctx).pn = match(ID);
			setState(51);
			((ProblemContext)_localctx).dn = match(ID);
			setState(52);
			((ProblemContext)_localctx).state = latomlist();
			setState(53);
			((ProblemContext)_localctx).tl = tasklist();
			setState(54);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DomainContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(JSHOP2Parser.ID, 0); }
		public List<PdeContext> pde() {
			return getRuleContexts(PdeContext.class);
		}
		public PdeContext pde(int i) {
			return getRuleContext(PdeContext.class,i);
		}
		public DomainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_domain; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterDomain(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitDomain(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSHOP2Visitor ) return ((JSHOP2Visitor<? extends T>)visitor).visitDomain(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DomainContext domain() throws RecognitionException {
		DomainContext _localctx = new DomainContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_domain);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			match(T__0);
			setState(57);
			match(T__3);
			setState(58);
			match(ID);
			setState(59);
			match(T__0);
			setState(61); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(60);
				pde();
				}
				}
				setState(63); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__0 );
			setState(65);
			match(T__2);
			setState(66);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PdeContext extends ParserRuleContext {
		public MethodContext method() {
			return getRuleContext(MethodContext.class,0);
		}
		public OperatorContext operator() {
			return getRuleContext(OperatorContext.class,0);
		}
		public AxiomContext axiom() {
			return getRuleContext(AxiomContext.class,0);
		}
		public PdeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pde; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterPde(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitPde(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSHOP2Visitor ) return ((JSHOP2Visitor<? extends T>)visitor).visitPde(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PdeContext pde() throws RecognitionException {
		PdeContext _localctx = new PdeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_pde);
		try {
			setState(71);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(68);
				method();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(69);
				operator();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(70);
				axiom();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(JSHOP2Parser.ID, 0); }
		public TermlContext terml() {
			return getRuleContext(TermlContext.class,0);
		}
		public List<MethodsubContext> methodsub() {
			return getRuleContexts(MethodsubContext.class);
		}
		public MethodsubContext methodsub(int i) {
			return getRuleContext(MethodsubContext.class,i);
		}
		public MethodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitMethod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSHOP2Visitor ) return ((JSHOP2Visitor<? extends T>)visitor).visitMethod(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodContext method() throws RecognitionException {
		MethodContext _localctx = new MethodContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_method);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			match(T__0);
			setState(74);
			match(T__4);
			setState(75);
			match(T__0);
			setState(76);
			match(ID);
			setState(77);
			terml();
			setState(78);
			match(T__2);
			setState(80); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(79);
				methodsub();
				}
				}
				setState(82); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__7) | (1L << ID) | (1L << VARID))) != 0) );
			setState(84);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodsubContext extends ParserRuleContext {
		public LprecondContext pre;
		public TasklistContext tl;
		public LprecondContext lprecond() {
			return getRuleContext(LprecondContext.class,0);
		}
		public TasklistContext tasklist() {
			return getRuleContext(TasklistContext.class,0);
		}
		public TerminalNode ID() { return getToken(JSHOP2Parser.ID, 0); }
		public MethodsubContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodsub; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterMethodsub(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitMethodsub(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSHOP2Visitor ) return ((JSHOP2Visitor<? extends T>)visitor).visitMethodsub(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodsubContext methodsub() throws RecognitionException {
		MethodsubContext _localctx = new MethodsubContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_methodsub);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(86);
				match(ID);
				}
			}

			setState(89);
			((MethodsubContext)_localctx).pre = lprecond();
			setState(90);
			((MethodsubContext)_localctx).tl = tasklist();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OperatorContext extends ParserRuleContext {
		public LprecondContext pre;
		public DeladdContext del;
		public DeladdContext add;
		public TermContext cost;
		public TerminalNode OPID() { return getToken(JSHOP2Parser.OPID, 0); }
		public TermlContext terml() {
			return getRuleContext(TermlContext.class,0);
		}
		public LprecondContext lprecond() {
			return getRuleContext(LprecondContext.class,0);
		}
		public List<DeladdContext> deladd() {
			return getRuleContexts(DeladdContext.class);
		}
		public DeladdContext deladd(int i) {
			return getRuleContext(DeladdContext.class,i);
		}
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public OperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSHOP2Visitor ) return ((JSHOP2Visitor<? extends T>)visitor).visitOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperatorContext operator() throws RecognitionException {
		OperatorContext _localctx = new OperatorContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(T__0);
			setState(93);
			match(T__5);
			setState(94);
			match(T__0);
			setState(95);
			match(OPID);
			setState(96);
			terml();
			setState(97);
			match(T__2);
			setState(98);
			((OperatorContext)_localctx).pre = lprecond();
			setState(99);
			((OperatorContext)_localctx).del = deladd();
			setState(100);
			((OperatorContext)_localctx).add = deladd();
			setState(102);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__7) | (1L << ID) | (1L << VARID) | (1L << NUM))) != 0)) {
				{
				setState(101);
				((OperatorContext)_localctx).cost = term();
				}
			}

			setState(104);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AxiomContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(JSHOP2Parser.ID, 0); }
		public TermlContext terml() {
			return getRuleContext(TermlContext.class,0);
		}
		public List<AxiomsubContext> axiomsub() {
			return getRuleContexts(AxiomsubContext.class);
		}
		public AxiomsubContext axiomsub(int i) {
			return getRuleContext(AxiomsubContext.class,i);
		}
		public AxiomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_axiom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterAxiom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitAxiom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSHOP2Visitor ) return ((JSHOP2Visitor<? extends T>)visitor).visitAxiom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AxiomContext axiom() throws RecognitionException {
		AxiomContext _localctx = new AxiomContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_axiom);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			match(T__0);
			setState(107);
			match(T__6);
			setState(108);
			match(T__0);
			setState(109);
			match(ID);
			setState(110);
			terml();
			setState(111);
			match(T__2);
			setState(113); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(112);
				axiomsub();
				}
				}
				setState(115); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__7) | (1L << ID) | (1L << VARID))) != 0) );
			setState(117);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AxiomsubContext extends ParserRuleContext {
		public LprecondContext pre;
		public LprecondContext lprecond() {
			return getRuleContext(LprecondContext.class,0);
		}
		public TerminalNode ID() { return getToken(JSHOP2Parser.ID, 0); }
		public AxiomsubContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_axiomsub; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterAxiomsub(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitAxiomsub(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSHOP2Visitor ) return ((JSHOP2Visitor<? extends T>)visitor).visitAxiomsub(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AxiomsubContext axiomsub() throws RecognitionException {
		AxiomsubContext _localctx = new AxiomsubContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_axiomsub);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(119);
				match(ID);
				}
			}

			setState(122);
			((AxiomsubContext)_localctx).pre = lprecond();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeladdContext extends ParserRuleContext {
		public DeladdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_deladd; }
	 
		public DeladdContext() { }
		public void copyFrom(DeladdContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DelAdd_BasicContext extends DeladdContext {
		public List<DeladdeleContext> deladdele() {
			return getRuleContexts(DeladdeleContext.class);
		}
		public DeladdeleContext deladdele(int i) {
			return getRuleContext(DeladdeleContext.class,i);
		}
		public DelAdd_BasicContext(DeladdContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterDelAdd_Basic(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitDelAdd_Basic(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSHOP2Visitor ) return ((JSHOP2Visitor<? extends T>)visitor).visitDelAdd_Basic(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DelAdd_VarContext extends DeladdContext {
		public TerminalNode VARID() { return getToken(JSHOP2Parser.VARID, 0); }
		public DelAdd_VarContext(DeladdContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterDelAdd_Var(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitDelAdd_Var(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSHOP2Visitor ) return ((JSHOP2Visitor<? extends T>)visitor).visitDelAdd_Var(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DelAdd_NilContext extends DeladdContext {
		public DelAdd_NilContext(DeladdContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterDelAdd_Nil(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitDelAdd_Nil(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSHOP2Visitor ) return ((JSHOP2Visitor<? extends T>)visitor).visitDelAdd_Nil(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeladdContext deladd() throws RecognitionException {
		DeladdContext _localctx = new DeladdContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_deladd);
		int _la;
		try {
			setState(134);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				_localctx = new DelAdd_BasicContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(124);
				match(T__0);
				setState(128);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0 || _la==VARID) {
					{
					{
					setState(125);
					deladdele();
					}
					}
					setState(130);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(131);
				match(T__2);
				}
				break;
			case VARID:
				_localctx = new DelAdd_VarContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(132);
				match(VARID);
				}
				break;
			case T__7:
				_localctx = new DelAdd_NilContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(133);
				match(T__7);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeladdeleContext extends ParserRuleContext {
		public DeladdeleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_deladdele; }
	 
		public DeladdeleContext() { }
		public void copyFrom(DeladdeleContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DelAddEle_ProtectContext extends DeladdeleContext {
		public LatomContext latom() {
			return getRuleContext(LatomContext.class,0);
		}
		public DelAddEle_ProtectContext(DeladdeleContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterDelAddEle_Protect(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitDelAddEle_Protect(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSHOP2Visitor ) return ((JSHOP2Visitor<? extends T>)visitor).visitDelAddEle_Protect(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DelAddEle_AtomContext extends DeladdeleContext {
		public LatomContext latom() {
			return getRuleContext(LatomContext.class,0);
		}
		public DelAddEle_AtomContext(DeladdeleContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterDelAddEle_Atom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitDelAddEle_Atom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSHOP2Visitor ) return ((JSHOP2Visitor<? extends T>)visitor).visitDelAddEle_Atom(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DelAddEle_ForAllContext extends DeladdeleContext {
		public LexpContext lexp() {
			return getRuleContext(LexpContext.class,0);
		}
		public LatomlistContext latomlist() {
			return getRuleContext(LatomlistContext.class,0);
		}
		public DelAddEle_ForAllContext(DeladdeleContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterDelAddEle_ForAll(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitDelAddEle_ForAll(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSHOP2Visitor ) return ((JSHOP2Visitor<? extends T>)visitor).visitDelAddEle_ForAll(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeladdeleContext deladdele() throws RecognitionException {
		DeladdeleContext _localctx = new DeladdeleContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_deladdele);
		try {
			setState(148);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				_localctx = new DelAddEle_AtomContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(136);
				latom();
				}
				break;
			case 2:
				_localctx = new DelAddEle_ProtectContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(137);
				match(T__0);
				setState(138);
				match(T__8);
				setState(139);
				latom();
				setState(140);
				match(T__2);
				}
				break;
			case 3:
				_localctx = new DelAddEle_ForAllContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(142);
				match(T__0);
				setState(143);
				match(T__9);
				setState(144);
				lexp();
				setState(145);
				latomlist();
				setState(146);
				match(T__2);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TasklistContext extends ParserRuleContext {
		public TasklistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tasklist; }
	 
		public TasklistContext() { }
		public void copyFrom(TasklistContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TaskList_BasicContext extends TasklistContext {
		public TerminalNode UNORDERED() { return getToken(JSHOP2Parser.UNORDERED, 0); }
		public List<TasklistsubContext> tasklistsub() {
			return getRuleContexts(TasklistsubContext.class);
		}
		public TasklistsubContext tasklistsub(int i) {
			return getRuleContext(TasklistsubContext.class,i);
		}
		public TaskList_BasicContext(TasklistContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterTaskList_Basic(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitTaskList_Basic(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSHOP2Visitor ) return ((JSHOP2Visitor<? extends T>)visitor).visitTaskList_Basic(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TaskList_NilContext extends TasklistContext {
		public TaskList_NilContext(TasklistContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterTaskList_Nil(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitTaskList_Nil(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSHOP2Visitor ) return ((JSHOP2Visitor<? extends T>)visitor).visitTaskList_Nil(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TasklistContext tasklist() throws RecognitionException {
		TasklistContext _localctx = new TasklistContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_tasklist);
		int _la;
		try {
			setState(162);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				_localctx = new TaskList_BasicContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(150);
				match(T__0);
				setState(152);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==UNORDERED) {
					{
					setState(151);
					match(UNORDERED);
					}
				}

				setState(157);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0 || _la==T__7) {
					{
					{
					setState(154);
					tasklistsub();
					}
					}
					setState(159);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(160);
				match(T__2);
				}
				break;
			case T__7:
				_localctx = new TaskList_NilContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(161);
				match(T__7);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TasklistsubContext extends ParserRuleContext {
		public TasklistsubContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tasklistsub; }
	 
		public TasklistsubContext() { }
		public void copyFrom(TasklistsubContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TaskListSub_ListContext extends TasklistsubContext {
		public TasklistContext tasklist() {
			return getRuleContext(TasklistContext.class,0);
		}
		public TaskListSub_ListContext(TasklistsubContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterTaskListSub_List(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitTaskListSub_List(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSHOP2Visitor ) return ((JSHOP2Visitor<? extends T>)visitor).visitTaskListSub_List(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TaskListSub_AtomContext extends TasklistsubContext {
		public TaskatomContext taskatom() {
			return getRuleContext(TaskatomContext.class,0);
		}
		public TaskListSub_AtomContext(TasklistsubContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterTaskListSub_Atom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitTaskListSub_Atom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSHOP2Visitor ) return ((JSHOP2Visitor<? extends T>)visitor).visitTaskListSub_Atom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TasklistsubContext tasklistsub() throws RecognitionException {
		TasklistsubContext _localctx = new TasklistsubContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_tasklistsub);
		try {
			setState(166);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				_localctx = new TaskListSub_ListContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(164);
				tasklist();
				}
				break;
			case 2:
				_localctx = new TaskListSub_AtomContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(165);
				taskatom();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TaskatomContext extends ParserRuleContext {
		public TermlContext terml() {
			return getRuleContext(TermlContext.class,0);
		}
		public TerminalNode ID() { return getToken(JSHOP2Parser.ID, 0); }
		public TerminalNode OPID() { return getToken(JSHOP2Parser.OPID, 0); }
		public TerminalNode IMMEDIATE() { return getToken(JSHOP2Parser.IMMEDIATE, 0); }
		public TaskatomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_taskatom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterTaskatom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitTaskatom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSHOP2Visitor ) return ((JSHOP2Visitor<? extends T>)visitor).visitTaskatom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TaskatomContext taskatom() throws RecognitionException {
		TaskatomContext _localctx = new TaskatomContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_taskatom);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			match(T__0);
			setState(170);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IMMEDIATE) {
				{
				setState(169);
				match(IMMEDIATE);
				}
			}

			setState(172);
			_la = _input.LA(1);
			if ( !(_la==ID || _la==OPID) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(173);
			terml();
			setState(174);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LprecondContext extends ParserRuleContext {
		public LprecondContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lprecond; }
	 
		public LprecondContext() { }
		public void copyFrom(LprecondContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Precond_ExpContext extends LprecondContext {
		public LexpContext lexp() {
			return getRuleContext(LexpContext.class,0);
		}
		public Precond_ExpContext(LprecondContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterPrecond_Exp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitPrecond_Exp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSHOP2Visitor ) return ((JSHOP2Visitor<? extends T>)visitor).visitPrecond_Exp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Precond_FirstContext extends LprecondContext {
		public LexpContext lexp() {
			return getRuleContext(LexpContext.class,0);
		}
		public Precond_FirstContext(LprecondContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterPrecond_First(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitPrecond_First(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSHOP2Visitor ) return ((JSHOP2Visitor<? extends T>)visitor).visitPrecond_First(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Precond_SortByContext extends LprecondContext {
		public TerminalNode VARID() { return getToken(JSHOP2Parser.VARID, 0); }
		public LexpContext lexp() {
			return getRuleContext(LexpContext.class,0);
		}
		public CompnameContext compname() {
			return getRuleContext(CompnameContext.class,0);
		}
		public Precond_SortByContext(LprecondContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterPrecond_SortBy(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitPrecond_SortBy(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSHOP2Visitor ) return ((JSHOP2Visitor<? extends T>)visitor).visitPrecond_SortBy(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LprecondContext lprecond() throws RecognitionException {
		LprecondContext _localctx = new LprecondContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_lprecond);
		int _la;
		try {
			setState(191);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				_localctx = new Precond_ExpContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(176);
				lexp();
				}
				break;
			case 2:
				_localctx = new Precond_FirstContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(177);
				match(T__0);
				setState(178);
				match(T__10);
				setState(179);
				lexp();
				setState(180);
				match(T__2);
				}
				break;
			case 3:
				_localctx = new Precond_SortByContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(182);
				match(T__0);
				setState(183);
				match(T__11);
				setState(184);
				match(VARID);
				setState(186);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__12) | (1L << T__13) | (1L << ID))) != 0)) {
					{
					setState(185);
					compname();
					}
				}

				setState(188);
				lexp();
				setState(189);
				match(T__2);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CompnameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(JSHOP2Parser.ID, 0); }
		public CompnameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compname; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterCompname(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitCompname(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSHOP2Visitor ) return ((JSHOP2Visitor<? extends T>)visitor).visitCompname(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompnameContext compname() throws RecognitionException {
		CompnameContext _localctx = new CompnameContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_compname);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(193);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__12) | (1L << T__13) | (1L << ID))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LexpContext extends ParserRuleContext {
		public LexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lexp; }
	 
		public LexpContext() { }
		public void copyFrom(LexpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Exp_NilContext extends LexpContext {
		public Exp_NilContext(LexpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterExp_Nil(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitExp_Nil(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSHOP2Visitor ) return ((JSHOP2Visitor<? extends T>)visitor).visitExp_Nil(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Exp_AtomContext extends LexpContext {
		public LatomContext latom() {
			return getRuleContext(LatomContext.class,0);
		}
		public Exp_AtomContext(LexpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterExp_Atom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitExp_Atom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSHOP2Visitor ) return ((JSHOP2Visitor<? extends T>)visitor).visitExp_Atom(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Exp_CallContext extends LexpContext {
		public FuncnameContext funcname() {
			return getRuleContext(FuncnameContext.class,0);
		}
		public TermlContext terml() {
			return getRuleContext(TermlContext.class,0);
		}
		public Exp_CallContext(LexpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterExp_Call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitExp_Call(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSHOP2Visitor ) return ((JSHOP2Visitor<? extends T>)visitor).visitExp_Call(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Exp_OrContext extends LexpContext {
		public List<LexpContext> lexp() {
			return getRuleContexts(LexpContext.class);
		}
		public LexpContext lexp(int i) {
			return getRuleContext(LexpContext.class,i);
		}
		public Exp_OrContext(LexpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterExp_Or(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitExp_Or(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSHOP2Visitor ) return ((JSHOP2Visitor<? extends T>)visitor).visitExp_Or(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Exp_AssignContext extends LexpContext {
		public TerminalNode VARID() { return getToken(JSHOP2Parser.VARID, 0); }
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public Exp_AssignContext(LexpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterExp_Assign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitExp_Assign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSHOP2Visitor ) return ((JSHOP2Visitor<? extends T>)visitor).visitExp_Assign(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Exp_ImplyContext extends LexpContext {
		public List<LexpContext> lexp() {
			return getRuleContexts(LexpContext.class);
		}
		public LexpContext lexp(int i) {
			return getRuleContext(LexpContext.class,i);
		}
		public Exp_ImplyContext(LexpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterExp_Imply(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitExp_Imply(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSHOP2Visitor ) return ((JSHOP2Visitor<? extends T>)visitor).visitExp_Imply(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Exp_NotContext extends LexpContext {
		public LexpContext lexp() {
			return getRuleContext(LexpContext.class,0);
		}
		public Exp_NotContext(LexpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterExp_Not(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitExp_Not(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSHOP2Visitor ) return ((JSHOP2Visitor<? extends T>)visitor).visitExp_Not(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Exp_AndContext extends LexpContext {
		public List<LexpContext> lexp() {
			return getRuleContexts(LexpContext.class);
		}
		public LexpContext lexp(int i) {
			return getRuleContext(LexpContext.class,i);
		}
		public Exp_AndContext(LexpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterExp_And(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitExp_And(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSHOP2Visitor ) return ((JSHOP2Visitor<? extends T>)visitor).visitExp_And(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Exp_ForAllContext extends LexpContext {
		public List<LexpContext> lexp() {
			return getRuleContexts(LexpContext.class);
		}
		public LexpContext lexp(int i) {
			return getRuleContext(LexpContext.class,i);
		}
		public Exp_ForAllContext(LexpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterExp_ForAll(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitExp_ForAll(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSHOP2Visitor ) return ((JSHOP2Visitor<? extends T>)visitor).visitExp_ForAll(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LexpContext lexp() throws RecognitionException {
		LexpContext _localctx = new LexpContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_lexp);
		int _la;
		try {
			setState(246);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				_localctx = new Exp_NilContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(195);
				match(T__7);
				}
				break;
			case 2:
				_localctx = new Exp_AndContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(196);
				match(T__0);
				setState(198);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__14) {
					{
					setState(197);
					match(T__14);
					}
				}

				setState(203);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__7) | (1L << VARID))) != 0)) {
					{
					{
					setState(200);
					lexp();
					}
					}
					setState(205);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(206);
				match(T__2);
				}
				break;
			case 3:
				_localctx = new Exp_OrContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(207);
				match(T__0);
				setState(208);
				match(T__15);
				setState(210); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(209);
					lexp();
					}
					}
					setState(212); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__7) | (1L << VARID))) != 0) );
				setState(214);
				match(T__2);
				}
				break;
			case 4:
				_localctx = new Exp_NotContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(216);
				match(T__0);
				setState(217);
				match(T__16);
				setState(218);
				lexp();
				setState(219);
				match(T__2);
				}
				break;
			case 5:
				_localctx = new Exp_ImplyContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(221);
				match(T__0);
				setState(222);
				match(T__17);
				setState(223);
				lexp();
				setState(224);
				lexp();
				setState(225);
				match(T__2);
				}
				break;
			case 6:
				_localctx = new Exp_AtomContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(227);
				latom();
				}
				break;
			case 7:
				_localctx = new Exp_ForAllContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(228);
				match(T__0);
				setState(229);
				match(T__9);
				setState(230);
				lexp();
				setState(231);
				lexp();
				setState(232);
				match(T__2);
				}
				break;
			case 8:
				_localctx = new Exp_AssignContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(234);
				match(T__0);
				setState(235);
				match(T__18);
				setState(236);
				match(VARID);
				setState(237);
				term();
				setState(238);
				match(T__2);
				}
				break;
			case 9:
				_localctx = new Exp_CallContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(240);
				match(T__0);
				setState(241);
				match(T__19);
				setState(242);
				funcname();
				setState(243);
				terml();
				setState(244);
				match(T__2);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LatomlistContext extends ParserRuleContext {
		public LatomlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_latomlist; }
	 
		public LatomlistContext() { }
		public void copyFrom(LatomlistContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AtomList_BasicContext extends LatomlistContext {
		public List<LatomContext> latom() {
			return getRuleContexts(LatomContext.class);
		}
		public LatomContext latom(int i) {
			return getRuleContext(LatomContext.class,i);
		}
		public AtomList_BasicContext(LatomlistContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterAtomList_Basic(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitAtomList_Basic(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSHOP2Visitor ) return ((JSHOP2Visitor<? extends T>)visitor).visitAtomList_Basic(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AtomList_NilContext extends LatomlistContext {
		public AtomList_NilContext(LatomlistContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterAtomList_Nil(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitAtomList_Nil(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSHOP2Visitor ) return ((JSHOP2Visitor<? extends T>)visitor).visitAtomList_Nil(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LatomlistContext latomlist() throws RecognitionException {
		LatomlistContext _localctx = new LatomlistContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_latomlist);
		int _la;
		try {
			setState(257);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				_localctx = new AtomList_BasicContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(248);
				match(T__0);
				setState(252);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0 || _la==VARID) {
					{
					{
					setState(249);
					latom();
					}
					}
					setState(254);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(255);
				match(T__2);
				}
				break;
			case T__7:
				_localctx = new AtomList_NilContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(256);
				match(T__7);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LatomContext extends ParserRuleContext {
		public LatomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_latom; }
	 
		public LatomContext() { }
		public void copyFrom(LatomContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Atom_VarContext extends LatomContext {
		public TerminalNode VARID() { return getToken(JSHOP2Parser.VARID, 0); }
		public Atom_VarContext(LatomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterAtom_Var(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitAtom_Var(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSHOP2Visitor ) return ((JSHOP2Visitor<? extends T>)visitor).visitAtom_Var(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Atom_BasicContext extends LatomContext {
		public TerminalNode ID() { return getToken(JSHOP2Parser.ID, 0); }
		public TermlContext terml() {
			return getRuleContext(TermlContext.class,0);
		}
		public Atom_BasicContext(LatomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterAtom_Basic(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitAtom_Basic(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSHOP2Visitor ) return ((JSHOP2Visitor<? extends T>)visitor).visitAtom_Basic(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LatomContext latom() throws RecognitionException {
		LatomContext _localctx = new LatomContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_latom);
		try {
			setState(265);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				_localctx = new Atom_BasicContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(259);
				match(T__0);
				setState(260);
				match(ID);
				setState(261);
				terml();
				setState(262);
				match(T__2);
				}
				break;
			case VARID:
				_localctx = new Atom_VarContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(264);
				match(VARID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncnameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(JSHOP2Parser.ID, 0); }
		public TerminalNode WS() { return getToken(JSHOP2Parser.WS, 0); }
		public FuncnameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcname; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterFuncname(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitFuncname(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSHOP2Visitor ) return ((JSHOP2Visitor<? extends T>)visitor).visitFuncname(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncnameContext funcname() throws RecognitionException {
		FuncnameContext _localctx = new FuncnameContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_funcname);
		try {
			setState(282);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(267);
				match(ID);
				}
				break;
			case T__20:
				enterOuterAlt(_localctx, 2);
				{
				setState(268);
				match(T__20);
				}
				break;
			case T__21:
				enterOuterAlt(_localctx, 3);
				{
				setState(269);
				match(T__21);
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 4);
				{
				setState(270);
				match(T__12);
				}
				break;
			case T__22:
				enterOuterAlt(_localctx, 5);
				{
				setState(271);
				match(T__22);
				}
				break;
			case T__23:
				enterOuterAlt(_localctx, 6);
				{
				setState(272);
				match(T__23);
				}
				break;
			case T__24:
				enterOuterAlt(_localctx, 7);
				{
				setState(273);
				match(T__24);
				setState(274);
				match(WS);
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 8);
				{
				setState(275);
				match(T__13);
				}
				break;
			case T__25:
				enterOuterAlt(_localctx, 9);
				{
				setState(276);
				match(T__25);
				}
				break;
			case T__26:
				enterOuterAlt(_localctx, 10);
				{
				setState(277);
				match(T__26);
				}
				break;
			case T__27:
				enterOuterAlt(_localctx, 11);
				{
				setState(278);
				match(T__27);
				}
				break;
			case T__28:
				enterOuterAlt(_localctx, 12);
				{
				setState(279);
				match(T__28);
				setState(280);
				match(WS);
				}
				break;
			case T__29:
				enterOuterAlt(_localctx, 13);
				{
				setState(281);
				match(T__29);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TermlContext extends ParserRuleContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public TermlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_terml; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterTerml(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitTerml(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSHOP2Visitor ) return ((JSHOP2Visitor<? extends T>)visitor).visitTerml(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermlContext terml() throws RecognitionException {
		TermlContext _localctx = new TermlContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_terml);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(287);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__7) | (1L << ID) | (1L << VARID) | (1L << NUM))) != 0)) {
				{
				{
				setState(284);
				term();
				}
				}
				setState(289);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TermContext extends ParserRuleContext {
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
	 
		public TermContext() { }
		public void copyFrom(TermContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Term_ListContext extends TermContext {
		public TermlContext terml() {
			return getRuleContext(TermlContext.class,0);
		}
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public Term_ListContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterTerm_List(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitTerm_List(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSHOP2Visitor ) return ((JSHOP2Visitor<? extends T>)visitor).visitTerm_List(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Term_NilContext extends TermContext {
		public Term_NilContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterTerm_Nil(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitTerm_Nil(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSHOP2Visitor ) return ((JSHOP2Visitor<? extends T>)visitor).visitTerm_Nil(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Term_ConstContext extends TermContext {
		public TerminalNode ID() { return getToken(JSHOP2Parser.ID, 0); }
		public Term_ConstContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterTerm_Const(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitTerm_Const(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSHOP2Visitor ) return ((JSHOP2Visitor<? extends T>)visitor).visitTerm_Const(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Term_VarContext extends TermContext {
		public TerminalNode VARID() { return getToken(JSHOP2Parser.VARID, 0); }
		public Term_VarContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterTerm_Var(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitTerm_Var(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSHOP2Visitor ) return ((JSHOP2Visitor<? extends T>)visitor).visitTerm_Var(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Term_CallContext extends TermContext {
		public FuncnameContext funcname() {
			return getRuleContext(FuncnameContext.class,0);
		}
		public TermlContext terml() {
			return getRuleContext(TermlContext.class,0);
		}
		public Term_CallContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterTerm_Call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitTerm_Call(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSHOP2Visitor ) return ((JSHOP2Visitor<? extends T>)visitor).visitTerm_Call(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Term_NumContext extends TermContext {
		public TerminalNode NUM() { return getToken(JSHOP2Parser.NUM, 0); }
		public Term_NumContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).enterTerm_Num(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof JSHOP2Listener ) ((JSHOP2Listener)listener).exitTerm_Num(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JSHOP2Visitor ) return ((JSHOP2Visitor<? extends T>)visitor).visitTerm_Num(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_term);
		int _la;
		try {
			setState(308);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				_localctx = new Term_VarContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(290);
				match(VARID);
				}
				break;
			case 2:
				_localctx = new Term_ConstContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(291);
				match(ID);
				}
				break;
			case 3:
				_localctx = new Term_NumContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(292);
				match(NUM);
				}
				break;
			case 4:
				_localctx = new Term_ListContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(293);
				match(T__0);
				setState(294);
				terml();
				setState(297);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__30) {
					{
					setState(295);
					match(T__30);
					setState(296);
					term();
					}
				}

				setState(299);
				match(T__2);
				}
				break;
			case 5:
				_localctx = new Term_NilContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(301);
				match(T__7);
				}
				break;
			case 6:
				_localctx = new Term_CallContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(302);
				match(T__0);
				setState(303);
				match(T__19);
				setState(304);
				funcname();
				setState(305);
				terml();
				setState(306);
				match(T__2);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3)\u0139\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\5\2\61\n\2"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\6\4@\n\4\r\4\16\4"+
		"A\3\4\3\4\3\4\3\5\3\5\3\5\5\5J\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\6\6S\n"+
		"\6\r\6\16\6T\3\6\3\6\3\7\5\7Z\n\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\5\bi\n\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\6\tt\n\t"+
		"\r\t\16\tu\3\t\3\t\3\n\5\n{\n\n\3\n\3\n\3\13\3\13\7\13\u0081\n\13\f\13"+
		"\16\13\u0084\13\13\3\13\3\13\3\13\5\13\u0089\n\13\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u0097\n\f\3\r\3\r\5\r\u009b\n\r\3\r\7"+
		"\r\u009e\n\r\f\r\16\r\u00a1\13\r\3\r\3\r\5\r\u00a5\n\r\3\16\3\16\5\16"+
		"\u00a9\n\16\3\17\3\17\5\17\u00ad\n\17\3\17\3\17\3\17\3\17\3\20\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00bd\n\20\3\20\3\20\3\20"+
		"\5\20\u00c2\n\20\3\21\3\21\3\22\3\22\3\22\5\22\u00c9\n\22\3\22\7\22\u00cc"+
		"\n\22\f\22\16\22\u00cf\13\22\3\22\3\22\3\22\3\22\6\22\u00d5\n\22\r\22"+
		"\16\22\u00d6\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3"+
		"\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3"+
		"\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u00f9\n\22\3\23\3\23\7\23\u00fd"+
		"\n\23\f\23\16\23\u0100\13\23\3\23\3\23\5\23\u0104\n\23\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\5\24\u010c\n\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u011d\n\25\3\26\7\26\u0120\n"+
		"\26\f\26\16\26\u0123\13\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u012c"+
		"\n\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u0137\n\27\3\27"+
		"\2\2\30\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,\2\4\3\2&\'\4\2"+
		"\17\20&&\2\u0159\2\60\3\2\2\2\4\62\3\2\2\2\6:\3\2\2\2\bI\3\2\2\2\nK\3"+
		"\2\2\2\fY\3\2\2\2\16^\3\2\2\2\20l\3\2\2\2\22z\3\2\2\2\24\u0088\3\2\2\2"+
		"\26\u0096\3\2\2\2\30\u00a4\3\2\2\2\32\u00a8\3\2\2\2\34\u00aa\3\2\2\2\36"+
		"\u00c1\3\2\2\2 \u00c3\3\2\2\2\"\u00f8\3\2\2\2$\u0103\3\2\2\2&\u010b\3"+
		"\2\2\2(\u011c\3\2\2\2*\u0121\3\2\2\2,\u0136\3\2\2\2.\61\5\6\4\2/\61\5"+
		"\4\3\2\60.\3\2\2\2\60/\3\2\2\2\61\3\3\2\2\2\62\63\7\3\2\2\63\64\7\4\2"+
		"\2\64\65\7&\2\2\65\66\7&\2\2\66\67\5$\23\2\678\5\30\r\289\7\5\2\29\5\3"+
		"\2\2\2:;\7\3\2\2;<\7\6\2\2<=\7&\2\2=?\7\3\2\2>@\5\b\5\2?>\3\2\2\2@A\3"+
		"\2\2\2A?\3\2\2\2AB\3\2\2\2BC\3\2\2\2CD\7\5\2\2DE\7\5\2\2E\7\3\2\2\2FJ"+
		"\5\n\6\2GJ\5\16\b\2HJ\5\20\t\2IF\3\2\2\2IG\3\2\2\2IH\3\2\2\2J\t\3\2\2"+
		"\2KL\7\3\2\2LM\7\7\2\2MN\7\3\2\2NO\7&\2\2OP\5*\26\2PR\7\5\2\2QS\5\f\7"+
		"\2RQ\3\2\2\2ST\3\2\2\2TR\3\2\2\2TU\3\2\2\2UV\3\2\2\2VW\7\5\2\2W\13\3\2"+
		"\2\2XZ\7&\2\2YX\3\2\2\2YZ\3\2\2\2Z[\3\2\2\2[\\\5\36\20\2\\]\5\30\r\2]"+
		"\r\3\2\2\2^_\7\3\2\2_`\7\b\2\2`a\7\3\2\2ab\7\'\2\2bc\5*\26\2cd\7\5\2\2"+
		"de\5\36\20\2ef\5\24\13\2fh\5\24\13\2gi\5,\27\2hg\3\2\2\2hi\3\2\2\2ij\3"+
		"\2\2\2jk\7\5\2\2k\17\3\2\2\2lm\7\3\2\2mn\7\t\2\2no\7\3\2\2op\7&\2\2pq"+
		"\5*\26\2qs\7\5\2\2rt\5\22\n\2sr\3\2\2\2tu\3\2\2\2us\3\2\2\2uv\3\2\2\2"+
		"vw\3\2\2\2wx\7\5\2\2x\21\3\2\2\2y{\7&\2\2zy\3\2\2\2z{\3\2\2\2{|\3\2\2"+
		"\2|}\5\36\20\2}\23\3\2\2\2~\u0082\7\3\2\2\177\u0081\5\26\f\2\u0080\177"+
		"\3\2\2\2\u0081\u0084\3\2\2\2\u0082\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083"+
		"\u0085\3\2\2\2\u0084\u0082\3\2\2\2\u0085\u0089\7\5\2\2\u0086\u0089\7("+
		"\2\2\u0087\u0089\7\n\2\2\u0088~\3\2\2\2\u0088\u0086\3\2\2\2\u0088\u0087"+
		"\3\2\2\2\u0089\25\3\2\2\2\u008a\u0097\5&\24\2\u008b\u008c\7\3\2\2\u008c"+
		"\u008d\7\13\2\2\u008d\u008e\5&\24\2\u008e\u008f\7\5\2\2\u008f\u0097\3"+
		"\2\2\2\u0090\u0091\7\3\2\2\u0091\u0092\7\f\2\2\u0092\u0093\5\"\22\2\u0093"+
		"\u0094\5$\23\2\u0094\u0095\7\5\2\2\u0095\u0097\3\2\2\2\u0096\u008a\3\2"+
		"\2\2\u0096\u008b\3\2\2\2\u0096\u0090\3\2\2\2\u0097\27\3\2\2\2\u0098\u009a"+
		"\7\3\2\2\u0099\u009b\7#\2\2\u009a\u0099\3\2\2\2\u009a\u009b\3\2\2\2\u009b"+
		"\u009f\3\2\2\2\u009c\u009e\5\32\16\2\u009d\u009c\3\2\2\2\u009e\u00a1\3"+
		"\2\2\2\u009f\u009d\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a2\3\2\2\2\u00a1"+
		"\u009f\3\2\2\2\u00a2\u00a5\7\5\2\2\u00a3\u00a5\7\n\2\2\u00a4\u0098\3\2"+
		"\2\2\u00a4\u00a3\3\2\2\2\u00a5\31\3\2\2\2\u00a6\u00a9\5\30\r\2\u00a7\u00a9"+
		"\5\34\17\2\u00a8\u00a6\3\2\2\2\u00a8\u00a7\3\2\2\2\u00a9\33\3\2\2\2\u00aa"+
		"\u00ac\7\3\2\2\u00ab\u00ad\7\"\2\2\u00ac\u00ab\3\2\2\2\u00ac\u00ad\3\2"+
		"\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00af\t\2\2\2\u00af\u00b0\5*\26\2\u00b0"+
		"\u00b1\7\5\2\2\u00b1\35\3\2\2\2\u00b2\u00c2\5\"\22\2\u00b3\u00b4\7\3\2"+
		"\2\u00b4\u00b5\7\r\2\2\u00b5\u00b6\5\"\22\2\u00b6\u00b7\7\5\2\2\u00b7"+
		"\u00c2\3\2\2\2\u00b8\u00b9\7\3\2\2\u00b9\u00ba\7\16\2\2\u00ba\u00bc\7"+
		"(\2\2\u00bb\u00bd\5 \21\2\u00bc\u00bb\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd"+
		"\u00be\3\2\2\2\u00be\u00bf\5\"\22\2\u00bf\u00c0\7\5\2\2\u00c0\u00c2\3"+
		"\2\2\2\u00c1\u00b2\3\2\2\2\u00c1\u00b3\3\2\2\2\u00c1\u00b8\3\2\2\2\u00c2"+
		"\37\3\2\2\2\u00c3\u00c4\t\3\2\2\u00c4!\3\2\2\2\u00c5\u00f9\7\n\2\2\u00c6"+
		"\u00c8\7\3\2\2\u00c7\u00c9\7\21\2\2\u00c8\u00c7\3\2\2\2\u00c8\u00c9\3"+
		"\2\2\2\u00c9\u00cd\3\2\2\2\u00ca\u00cc\5\"\22\2\u00cb\u00ca\3\2\2\2\u00cc"+
		"\u00cf\3\2\2\2\u00cd\u00cb\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce\u00d0\3\2"+
		"\2\2\u00cf\u00cd\3\2\2\2\u00d0\u00f9\7\5\2\2\u00d1\u00d2\7\3\2\2\u00d2"+
		"\u00d4\7\22\2\2\u00d3\u00d5\5\"\22\2\u00d4\u00d3\3\2\2\2\u00d5\u00d6\3"+
		"\2\2\2\u00d6\u00d4\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8"+
		"\u00d9\7\5\2\2\u00d9\u00f9\3\2\2\2\u00da\u00db\7\3\2\2\u00db\u00dc\7\23"+
		"\2\2\u00dc\u00dd\5\"\22\2\u00dd\u00de\7\5\2\2\u00de\u00f9\3\2\2\2\u00df"+
		"\u00e0\7\3\2\2\u00e0\u00e1\7\24\2\2\u00e1\u00e2\5\"\22\2\u00e2\u00e3\5"+
		"\"\22\2\u00e3\u00e4\7\5\2\2\u00e4\u00f9\3\2\2\2\u00e5\u00f9\5&\24\2\u00e6"+
		"\u00e7\7\3\2\2\u00e7\u00e8\7\f\2\2\u00e8\u00e9\5\"\22\2\u00e9\u00ea\5"+
		"\"\22\2\u00ea\u00eb\7\5\2\2\u00eb\u00f9\3\2\2\2\u00ec\u00ed\7\3\2\2\u00ed"+
		"\u00ee\7\25\2\2\u00ee\u00ef\7(\2\2\u00ef\u00f0\5,\27\2\u00f0\u00f1\7\5"+
		"\2\2\u00f1\u00f9\3\2\2\2\u00f2\u00f3\7\3\2\2\u00f3\u00f4\7\26\2\2\u00f4"+
		"\u00f5\5(\25\2\u00f5\u00f6\5*\26\2\u00f6\u00f7\7\5\2\2\u00f7\u00f9\3\2"+
		"\2\2\u00f8\u00c5\3\2\2\2\u00f8\u00c6\3\2\2\2\u00f8\u00d1\3\2\2\2\u00f8"+
		"\u00da\3\2\2\2\u00f8\u00df\3\2\2\2\u00f8\u00e5\3\2\2\2\u00f8\u00e6\3\2"+
		"\2\2\u00f8\u00ec\3\2\2\2\u00f8\u00f2\3\2\2\2\u00f9#\3\2\2\2\u00fa\u00fe"+
		"\7\3\2\2\u00fb\u00fd\5&\24\2\u00fc\u00fb\3\2\2\2\u00fd\u0100\3\2\2\2\u00fe"+
		"\u00fc\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff\u0101\3\2\2\2\u0100\u00fe\3\2"+
		"\2\2\u0101\u0104\7\5\2\2\u0102\u0104\7\n\2\2\u0103\u00fa\3\2\2\2\u0103"+
		"\u0102\3\2\2\2\u0104%\3\2\2\2\u0105\u0106\7\3\2\2\u0106\u0107\7&\2\2\u0107"+
		"\u0108\5*\26\2\u0108\u0109\7\5\2\2\u0109\u010c\3\2\2\2\u010a\u010c\7("+
		"\2\2\u010b\u0105\3\2\2\2\u010b\u010a\3\2\2\2\u010c\'\3\2\2\2\u010d\u011d"+
		"\7&\2\2\u010e\u011d\7\27\2\2\u010f\u011d\7\30\2\2\u0110\u011d\7\17\2\2"+
		"\u0111\u011d\7\31\2\2\u0112\u011d\7\32\2\2\u0113\u0114\7\33\2\2\u0114"+
		"\u011d\7$\2\2\u0115\u011d\7\20\2\2\u0116\u011d\7\34\2\2\u0117\u011d\7"+
		"\35\2\2\u0118\u011d\7\36\2\2\u0119\u011a\7\37\2\2\u011a\u011d\7$\2\2\u011b"+
		"\u011d\7 \2\2\u011c\u010d\3\2\2\2\u011c\u010e\3\2\2\2\u011c\u010f\3\2"+
		"\2\2\u011c\u0110\3\2\2\2\u011c\u0111\3\2\2\2\u011c\u0112\3\2\2\2\u011c"+
		"\u0113\3\2\2\2\u011c\u0115\3\2\2\2\u011c\u0116\3\2\2\2\u011c\u0117\3\2"+
		"\2\2\u011c\u0118\3\2\2\2\u011c\u0119\3\2\2\2\u011c\u011b\3\2\2\2\u011d"+
		")\3\2\2\2\u011e\u0120\5,\27\2\u011f\u011e\3\2\2\2\u0120\u0123\3\2\2\2"+
		"\u0121\u011f\3\2\2\2\u0121\u0122\3\2\2\2\u0122+\3\2\2\2\u0123\u0121\3"+
		"\2\2\2\u0124\u0137\7(\2\2\u0125\u0137\7&\2\2\u0126\u0137\7)\2\2\u0127"+
		"\u0128\7\3\2\2\u0128\u012b\5*\26\2\u0129\u012a\7!\2\2\u012a\u012c\5,\27"+
		"\2\u012b\u0129\3\2\2\2\u012b\u012c\3\2\2\2\u012c\u012d\3\2\2\2\u012d\u012e"+
		"\7\5\2\2\u012e\u0137\3\2\2\2\u012f\u0137\7\n\2\2\u0130\u0131\7\3\2\2\u0131"+
		"\u0132\7\26\2\2\u0132\u0133\5(\25\2\u0133\u0134\5*\26\2\u0134\u0135\7"+
		"\5\2\2\u0135\u0137\3\2\2\2\u0136\u0124\3\2\2\2\u0136\u0125\3\2\2\2\u0136"+
		"\u0126\3\2\2\2\u0136\u0127\3\2\2\2\u0136\u012f\3\2\2\2\u0136\u0130\3\2"+
		"\2\2\u0137-\3\2\2\2\37\60AITYhuz\u0082\u0088\u0096\u009a\u009f\u00a4\u00a8"+
		"\u00ac\u00bc\u00c1\u00c8\u00cd\u00d6\u00f8\u00fe\u0103\u010b\u011c\u0121"+
		"\u012b\u0136";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}