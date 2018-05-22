// Generated from Grammar.g4 by ANTLR 4.7.1

package Grammar;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, Alpha=38, 
		Digit=39, Null=40, Varchar=41, WS=42;
	public static final int
		RULE_program = 0, RULE_command = 1, RULE_open_cmd = 2, RULE_close_cmd = 3, 
		RULE_write_cmd = 4, RULE_exit_cmd = 5, RULE_show_cmd = 6, RULE_create_cmd = 7, 
		RULE_update_cmd = 8, RULE_insert_cmd = 9, RULE_delete_cmd = 10, RULE_typed_attribute_list = 11, 
		RULE_type = 12, RULE_integer = 13, RULE_query = 14, RULE_relation_name = 15, 
		RULE_expr = 16, RULE_atomic_expr = 17, RULE_selection = 18, RULE_projection = 19, 
		RULE_renaming = 20, RULE_union = 21, RULE_difference = 22, RULE_product = 23, 
		RULE_natural_join = 24, RULE_condition = 25, RULE_conjunction = 26, RULE_comparison = 27, 
		RULE_attribute_list = 28, RULE_identifier = 29, RULE_op = 30, RULE_operand = 31, 
		RULE_attribute_name = 32, RULE_literal = 33;
	public static final String[] ruleNames = {
		"program", "command", "open_cmd", "close_cmd", "write_cmd", "exit_cmd", 
		"show_cmd", "create_cmd", "update_cmd", "insert_cmd", "delete_cmd", "typed_attribute_list", 
		"type", "integer", "query", "relation_name", "expr", "atomic_expr", "selection", 
		"projection", "renaming", "union", "difference", "product", "natural_join", 
		"condition", "conjunction", "comparison", "attribute_list", "identifier", 
		"op", "operand", "attribute_name", "literal"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'OPEN'", "'CLOSE'", "'WRITE'", "'EXIT'", "'SHOW'", "'CREATE TABLE'", 
		"'('", "')'", "'PRIMARY KEY'", "'UPDATE'", "'SET'", "'='", "','", "'WHERE'", 
		"'INSERT INTO'", "'VALUES FROM'", "'VALUES FROM RELATION'", "'DELETE FROM'", 
		"'VARCHAR'", "'INTEGER'", "'<-'", "';'", "'select'", "'project'", "'rename'", 
		"'+'", "'-'", "'*'", "'&'", "'||'", "'&&'", "'=='", "'!='", "'<'", "'>'", 
		"'<='", "'>='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, "Alpha", "Digit", "Null", "Varchar", "WS"
	};
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
	public String getGrammarFileName() { return "Grammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public List<QueryContext> query() {
			return getRuleContexts(QueryContext.class);
		}
		public QueryContext query(int i) {
			return getRuleContext(QueryContext.class,i);
		}
		public List<CommandContext> command() {
			return getRuleContexts(CommandContext.class);
		}
		public CommandContext command(int i) {
			return getRuleContext(CommandContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__9) | (1L << T__14) | (1L << T__17) | (1L << Alpha))) != 0)) {
				{
				setState(70);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case Alpha:
					{
					setState(68);
					query();
					}
					break;
				case T__0:
				case T__1:
				case T__2:
				case T__3:
				case T__4:
				case T__5:
				case T__9:
				case T__14:
				case T__17:
					{
					setState(69);
					command();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(74);
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

	public static class CommandContext extends ParserRuleContext {
		public Open_cmdContext open_cmd() {
			return getRuleContext(Open_cmdContext.class,0);
		}
		public Close_cmdContext close_cmd() {
			return getRuleContext(Close_cmdContext.class,0);
		}
		public Write_cmdContext write_cmd() {
			return getRuleContext(Write_cmdContext.class,0);
		}
		public Exit_cmdContext exit_cmd() {
			return getRuleContext(Exit_cmdContext.class,0);
		}
		public Show_cmdContext show_cmd() {
			return getRuleContext(Show_cmdContext.class,0);
		}
		public Create_cmdContext create_cmd() {
			return getRuleContext(Create_cmdContext.class,0);
		}
		public Update_cmdContext update_cmd() {
			return getRuleContext(Update_cmdContext.class,0);
		}
		public Insert_cmdContext insert_cmd() {
			return getRuleContext(Insert_cmdContext.class,0);
		}
		public Delete_cmdContext delete_cmd() {
			return getRuleContext(Delete_cmdContext.class,0);
		}
		public CommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_command; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitCommand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitCommand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommandContext command() throws RecognitionException {
		CommandContext _localctx = new CommandContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_command);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				{
				setState(75);
				open_cmd();
				}
				break;
			case T__1:
				{
				setState(76);
				close_cmd();
				}
				break;
			case T__2:
				{
				setState(77);
				write_cmd();
				}
				break;
			case T__3:
				{
				setState(78);
				exit_cmd();
				}
				break;
			case T__4:
				{
				setState(79);
				show_cmd();
				}
				break;
			case T__5:
				{
				setState(80);
				create_cmd();
				}
				break;
			case T__9:
				{
				setState(81);
				update_cmd();
				}
				break;
			case T__14:
				{
				setState(82);
				insert_cmd();
				}
				break;
			case T__17:
				{
				setState(83);
				delete_cmd();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class Open_cmdContext extends ParserRuleContext {
		public Relation_nameContext relation_name() {
			return getRuleContext(Relation_nameContext.class,0);
		}
		public Open_cmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_open_cmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterOpen_cmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitOpen_cmd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitOpen_cmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Open_cmdContext open_cmd() throws RecognitionException {
		Open_cmdContext _localctx = new Open_cmdContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_open_cmd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			match(T__0);
			setState(87);
			relation_name();
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

	public static class Close_cmdContext extends ParserRuleContext {
		public Relation_nameContext relation_name() {
			return getRuleContext(Relation_nameContext.class,0);
		}
		public Close_cmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_close_cmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterClose_cmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitClose_cmd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitClose_cmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Close_cmdContext close_cmd() throws RecognitionException {
		Close_cmdContext _localctx = new Close_cmdContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_close_cmd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			match(T__1);
			setState(90);
			relation_name();
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

	public static class Write_cmdContext extends ParserRuleContext {
		public Relation_nameContext relation_name() {
			return getRuleContext(Relation_nameContext.class,0);
		}
		public Write_cmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_write_cmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterWrite_cmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitWrite_cmd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitWrite_cmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Write_cmdContext write_cmd() throws RecognitionException {
		Write_cmdContext _localctx = new Write_cmdContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_write_cmd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(T__2);
			setState(93);
			relation_name();
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

	public static class Exit_cmdContext extends ParserRuleContext {
		public Exit_cmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exit_cmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterExit_cmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitExit_cmd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitExit_cmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Exit_cmdContext exit_cmd() throws RecognitionException {
		Exit_cmdContext _localctx = new Exit_cmdContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_exit_cmd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			match(T__3);
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

	public static class Show_cmdContext extends ParserRuleContext {
		public Atomic_exprContext atomic_expr() {
			return getRuleContext(Atomic_exprContext.class,0);
		}
		public Show_cmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_show_cmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterShow_cmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitShow_cmd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitShow_cmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Show_cmdContext show_cmd() throws RecognitionException {
		Show_cmdContext _localctx = new Show_cmdContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_show_cmd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			match(T__4);
			setState(98);
			atomic_expr();
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

	public static class Create_cmdContext extends ParserRuleContext {
		public Relation_nameContext relation_name() {
			return getRuleContext(Relation_nameContext.class,0);
		}
		public Typed_attribute_listContext typed_attribute_list() {
			return getRuleContext(Typed_attribute_listContext.class,0);
		}
		public Attribute_listContext attribute_list() {
			return getRuleContext(Attribute_listContext.class,0);
		}
		public Create_cmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_create_cmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterCreate_cmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitCreate_cmd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitCreate_cmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Create_cmdContext create_cmd() throws RecognitionException {
		Create_cmdContext _localctx = new Create_cmdContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_create_cmd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			match(T__5);
			setState(101);
			relation_name();
			setState(102);
			match(T__6);
			setState(103);
			typed_attribute_list();
			setState(104);
			match(T__7);
			setState(105);
			match(T__8);
			setState(106);
			match(T__6);
			setState(107);
			attribute_list();
			setState(108);
			match(T__7);
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

	public static class Update_cmdContext extends ParserRuleContext {
		public Relation_nameContext relation_name() {
			return getRuleContext(Relation_nameContext.class,0);
		}
		public List<Attribute_nameContext> attribute_name() {
			return getRuleContexts(Attribute_nameContext.class);
		}
		public Attribute_nameContext attribute_name(int i) {
			return getRuleContext(Attribute_nameContext.class,i);
		}
		public List<LiteralContext> literal() {
			return getRuleContexts(LiteralContext.class);
		}
		public LiteralContext literal(int i) {
			return getRuleContext(LiteralContext.class,i);
		}
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public Update_cmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_update_cmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterUpdate_cmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitUpdate_cmd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitUpdate_cmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Update_cmdContext update_cmd() throws RecognitionException {
		Update_cmdContext _localctx = new Update_cmdContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_update_cmd);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			match(T__9);
			setState(111);
			relation_name();
			setState(112);
			match(T__10);
			setState(113);
			attribute_name();
			setState(114);
			match(T__11);
			setState(115);
			literal();
			setState(123);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__12) {
				{
				{
				setState(116);
				match(T__12);
				setState(117);
				attribute_name();
				setState(118);
				match(T__11);
				setState(119);
				literal();
				}
				}
				setState(125);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(126);
			match(T__13);
			setState(127);
			condition();
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

	public static class Insert_cmdContext extends ParserRuleContext {
		public Relation_nameContext relation_name() {
			return getRuleContext(Relation_nameContext.class,0);
		}
		public List<LiteralContext> literal() {
			return getRuleContexts(LiteralContext.class);
		}
		public LiteralContext literal(int i) {
			return getRuleContext(LiteralContext.class,i);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Insert_cmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_insert_cmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterInsert_cmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitInsert_cmd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitInsert_cmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Insert_cmdContext insert_cmd() throws RecognitionException {
		Insert_cmdContext _localctx = new Insert_cmdContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_insert_cmd);
		int _la;
		try {
			setState(148);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(129);
				match(T__14);
				setState(130);
				relation_name();
				setState(131);
				match(T__15);
				setState(132);
				match(T__6);
				setState(133);
				literal();
				setState(138);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__12) {
					{
					{
					setState(134);
					match(T__12);
					setState(135);
					literal();
					}
					}
					setState(140);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(141);
				match(T__7);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(143);
				match(T__14);
				setState(144);
				relation_name();
				setState(145);
				match(T__16);
				setState(146);
				expr();
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

	public static class Delete_cmdContext extends ParserRuleContext {
		public Relation_nameContext relation_name() {
			return getRuleContext(Relation_nameContext.class,0);
		}
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public Delete_cmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_delete_cmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterDelete_cmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitDelete_cmd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitDelete_cmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Delete_cmdContext delete_cmd() throws RecognitionException {
		Delete_cmdContext _localctx = new Delete_cmdContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_delete_cmd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			match(T__17);
			setState(151);
			relation_name();
			setState(152);
			match(T__13);
			setState(153);
			condition();
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

	public static class Typed_attribute_listContext extends ParserRuleContext {
		public List<Attribute_nameContext> attribute_name() {
			return getRuleContexts(Attribute_nameContext.class);
		}
		public Attribute_nameContext attribute_name(int i) {
			return getRuleContext(Attribute_nameContext.class,i);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public Typed_attribute_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typed_attribute_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterTyped_attribute_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitTyped_attribute_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitTyped_attribute_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Typed_attribute_listContext typed_attribute_list() throws RecognitionException {
		Typed_attribute_listContext _localctx = new Typed_attribute_listContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_typed_attribute_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			attribute_name();
			setState(156);
			type();
			setState(163);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__12) {
				{
				{
				setState(157);
				match(T__12);
				setState(158);
				attribute_name();
				setState(159);
				type();
				}
				}
				setState(165);
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

	public static class TypeContext extends ParserRuleContext {
		public IntegerContext integer() {
			return getRuleContext(IntegerContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_type);
		try {
			setState(172);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__18:
				enterOuterAlt(_localctx, 1);
				{
				setState(166);
				match(T__18);
				setState(167);
				match(T__6);
				setState(168);
				integer();
				setState(169);
				match(T__7);
				}
				break;
			case T__19:
				enterOuterAlt(_localctx, 2);
				{
				setState(171);
				match(T__19);
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

	public static class IntegerContext extends ParserRuleContext {
		public List<TerminalNode> Digit() { return getTokens(GrammarParser.Digit); }
		public TerminalNode Digit(int i) {
			return getToken(GrammarParser.Digit, i);
		}
		public IntegerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterInteger(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitInteger(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitInteger(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntegerContext integer() throws RecognitionException {
		IntegerContext _localctx = new IntegerContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_integer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			match(Digit);
			setState(178);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Digit) {
				{
				{
				setState(175);
				match(Digit);
				}
				}
				setState(180);
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

	public static class QueryContext extends ParserRuleContext {
		public Relation_nameContext relation_name() {
			return getRuleContext(Relation_nameContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public QueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitQuery(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitQuery(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QueryContext query() throws RecognitionException {
		QueryContext _localctx = new QueryContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_query);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
			relation_name();
			setState(182);
			match(T__20);
			setState(183);
			expr();
			setState(184);
			match(T__21);
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

	public static class Relation_nameContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Relation_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relation_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterRelation_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitRelation_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitRelation_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Relation_nameContext relation_name() throws RecognitionException {
		Relation_nameContext _localctx = new Relation_nameContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_relation_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			identifier();
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

	public static class ExprContext extends ParserRuleContext {
		public Atomic_exprContext atomic_expr() {
			return getRuleContext(Atomic_exprContext.class,0);
		}
		public SelectionContext selection() {
			return getRuleContext(SelectionContext.class,0);
		}
		public ProjectionContext projection() {
			return getRuleContext(ProjectionContext.class,0);
		}
		public RenamingContext renaming() {
			return getRuleContext(RenamingContext.class,0);
		}
		public UnionContext union() {
			return getRuleContext(UnionContext.class,0);
		}
		public DifferenceContext difference() {
			return getRuleContext(DifferenceContext.class,0);
		}
		public ProductContext product() {
			return getRuleContext(ProductContext.class,0);
		}
		public Natural_joinContext natural_join() {
			return getRuleContext(Natural_joinContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(188);
				atomic_expr();
				}
				break;
			case 2:
				{
				setState(189);
				selection();
				}
				break;
			case 3:
				{
				setState(190);
				projection();
				}
				break;
			case 4:
				{
				setState(191);
				renaming();
				}
				break;
			case 5:
				{
				setState(192);
				union();
				}
				break;
			case 6:
				{
				setState(193);
				difference();
				}
				break;
			case 7:
				{
				setState(194);
				product();
				}
				break;
			case 8:
				{
				setState(195);
				natural_join();
				}
				break;
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

	public static class Atomic_exprContext extends ParserRuleContext {
		public Relation_nameContext relation_name() {
			return getRuleContext(Relation_nameContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Atomic_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atomic_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterAtomic_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitAtomic_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitAtomic_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Atomic_exprContext atomic_expr() throws RecognitionException {
		Atomic_exprContext _localctx = new Atomic_exprContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_atomic_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Alpha:
				{
				setState(198);
				relation_name();
				}
				break;
			case T__6:
				{
				setState(199);
				match(T__6);
				setState(200);
				expr();
				setState(201);
				match(T__7);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class SelectionContext extends ParserRuleContext {
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public Atomic_exprContext atomic_expr() {
			return getRuleContext(Atomic_exprContext.class,0);
		}
		public SelectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selection; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterSelection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitSelection(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitSelection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectionContext selection() throws RecognitionException {
		SelectionContext _localctx = new SelectionContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_selection);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			match(T__22);
			setState(206);
			match(T__6);
			setState(207);
			condition();
			setState(208);
			match(T__7);
			setState(209);
			atomic_expr();
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

	public static class ProjectionContext extends ParserRuleContext {
		public Attribute_listContext attribute_list() {
			return getRuleContext(Attribute_listContext.class,0);
		}
		public Atomic_exprContext atomic_expr() {
			return getRuleContext(Atomic_exprContext.class,0);
		}
		public ProjectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_projection; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterProjection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitProjection(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitProjection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProjectionContext projection() throws RecognitionException {
		ProjectionContext _localctx = new ProjectionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_projection);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			match(T__23);
			setState(212);
			match(T__6);
			setState(213);
			attribute_list();
			setState(214);
			match(T__7);
			setState(215);
			atomic_expr();
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

	public static class RenamingContext extends ParserRuleContext {
		public Attribute_listContext attribute_list() {
			return getRuleContext(Attribute_listContext.class,0);
		}
		public Atomic_exprContext atomic_expr() {
			return getRuleContext(Atomic_exprContext.class,0);
		}
		public RenamingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_renaming; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterRenaming(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitRenaming(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitRenaming(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RenamingContext renaming() throws RecognitionException {
		RenamingContext _localctx = new RenamingContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_renaming);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			match(T__24);
			setState(218);
			match(T__6);
			setState(219);
			attribute_list();
			setState(220);
			match(T__7);
			setState(221);
			atomic_expr();
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

	public static class UnionContext extends ParserRuleContext {
		public List<Atomic_exprContext> atomic_expr() {
			return getRuleContexts(Atomic_exprContext.class);
		}
		public Atomic_exprContext atomic_expr(int i) {
			return getRuleContext(Atomic_exprContext.class,i);
		}
		public UnionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_union; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterUnion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitUnion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitUnion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnionContext union() throws RecognitionException {
		UnionContext _localctx = new UnionContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_union);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			atomic_expr();
			setState(224);
			match(T__25);
			setState(225);
			atomic_expr();
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

	public static class DifferenceContext extends ParserRuleContext {
		public List<Atomic_exprContext> atomic_expr() {
			return getRuleContexts(Atomic_exprContext.class);
		}
		public Atomic_exprContext atomic_expr(int i) {
			return getRuleContext(Atomic_exprContext.class,i);
		}
		public DifferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_difference; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterDifference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitDifference(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitDifference(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DifferenceContext difference() throws RecognitionException {
		DifferenceContext _localctx = new DifferenceContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_difference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(227);
			atomic_expr();
			setState(228);
			match(T__26);
			setState(229);
			atomic_expr();
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

	public static class ProductContext extends ParserRuleContext {
		public List<Atomic_exprContext> atomic_expr() {
			return getRuleContexts(Atomic_exprContext.class);
		}
		public Atomic_exprContext atomic_expr(int i) {
			return getRuleContext(Atomic_exprContext.class,i);
		}
		public ProductContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_product; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterProduct(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitProduct(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitProduct(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProductContext product() throws RecognitionException {
		ProductContext _localctx = new ProductContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_product);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
			atomic_expr();
			setState(232);
			match(T__27);
			setState(233);
			atomic_expr();
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

	public static class Natural_joinContext extends ParserRuleContext {
		public List<Atomic_exprContext> atomic_expr() {
			return getRuleContexts(Atomic_exprContext.class);
		}
		public Atomic_exprContext atomic_expr(int i) {
			return getRuleContext(Atomic_exprContext.class,i);
		}
		public Natural_joinContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_natural_join; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterNatural_join(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitNatural_join(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitNatural_join(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Natural_joinContext natural_join() throws RecognitionException {
		Natural_joinContext _localctx = new Natural_joinContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_natural_join);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(235);
			atomic_expr();
			setState(236);
			match(T__28);
			setState(237);
			atomic_expr();
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

	public static class ConditionContext extends ParserRuleContext {
		public List<ConjunctionContext> conjunction() {
			return getRuleContexts(ConjunctionContext.class);
		}
		public ConjunctionContext conjunction(int i) {
			return getRuleContext(ConjunctionContext.class,i);
		}
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_condition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
			conjunction();
			setState(244);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__29) {
				{
				{
				setState(240);
				match(T__29);
				setState(241);
				conjunction();
				}
				}
				setState(246);
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

	public static class ConjunctionContext extends ParserRuleContext {
		public List<ComparisonContext> comparison() {
			return getRuleContexts(ComparisonContext.class);
		}
		public ComparisonContext comparison(int i) {
			return getRuleContext(ComparisonContext.class,i);
		}
		public ConjunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conjunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterConjunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitConjunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitConjunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConjunctionContext conjunction() throws RecognitionException {
		ConjunctionContext _localctx = new ConjunctionContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_conjunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(247);
			comparison();
			setState(252);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__30) {
				{
				{
				setState(248);
				match(T__30);
				setState(249);
				comparison();
				}
				}
				setState(254);
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

	public static class ComparisonContext extends ParserRuleContext {
		public List<OperandContext> operand() {
			return getRuleContexts(OperandContext.class);
		}
		public OperandContext operand(int i) {
			return getRuleContext(OperandContext.class,i);
		}
		public OpContext op() {
			return getRuleContext(OpContext.class,0);
		}
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public ComparisonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparison; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterComparison(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitComparison(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitComparison(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparisonContext comparison() throws RecognitionException {
		ComparisonContext _localctx = new ComparisonContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_comparison);
		try {
			setState(263);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Alpha:
			case Digit:
			case Null:
			case Varchar:
				enterOuterAlt(_localctx, 1);
				{
				setState(255);
				operand();
				setState(256);
				op();
				setState(257);
				operand();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 2);
				{
				setState(259);
				match(T__6);
				setState(260);
				condition();
				setState(261);
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

	public static class Attribute_listContext extends ParserRuleContext {
		public List<Attribute_nameContext> attribute_name() {
			return getRuleContexts(Attribute_nameContext.class);
		}
		public Attribute_nameContext attribute_name(int i) {
			return getRuleContext(Attribute_nameContext.class,i);
		}
		public Attribute_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attribute_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterAttribute_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitAttribute_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitAttribute_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Attribute_listContext attribute_list() throws RecognitionException {
		Attribute_listContext _localctx = new Attribute_listContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_attribute_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(265);
			attribute_name();
			setState(270);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__12) {
				{
				{
				setState(266);
				match(T__12);
				setState(267);
				attribute_name();
				}
				}
				setState(272);
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

	public static class IdentifierContext extends ParserRuleContext {
		public List<TerminalNode> Alpha() { return getTokens(GrammarParser.Alpha); }
		public TerminalNode Alpha(int i) {
			return getToken(GrammarParser.Alpha, i);
		}
		public List<TerminalNode> Digit() { return getTokens(GrammarParser.Digit); }
		public TerminalNode Digit(int i) {
			return getToken(GrammarParser.Digit, i);
		}
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_identifier);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(273);
			match(Alpha);
			setState(277);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(274);
					_la = _input.LA(1);
					if ( !(_la==Alpha || _la==Digit) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					} 
				}
				setState(279);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
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

	public static class OpContext extends ParserRuleContext {
		public OpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OpContext op() throws RecognitionException {
		OpContext _localctx = new OpContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(280);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36))) != 0)) ) {
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

	public static class OperandContext extends ParserRuleContext {
		public Attribute_nameContext attribute_name() {
			return getRuleContext(Attribute_nameContext.class,0);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public OperandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterOperand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitOperand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitOperand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperandContext operand() throws RecognitionException {
		OperandContext _localctx = new OperandContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_operand);
		try {
			setState(284);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Alpha:
				enterOuterAlt(_localctx, 1);
				{
				setState(282);
				attribute_name();
				}
				break;
			case Digit:
			case Null:
			case Varchar:
				enterOuterAlt(_localctx, 2);
				{
				setState(283);
				literal();
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

	public static class Attribute_nameContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Attribute_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attribute_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterAttribute_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitAttribute_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitAttribute_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Attribute_nameContext attribute_name() throws RecognitionException {
		Attribute_nameContext _localctx = new Attribute_nameContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_attribute_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(286);
			identifier();
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

	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode Null() { return getToken(GrammarParser.Null, 0); }
		public IntegerContext integer() {
			return getRuleContext(IntegerContext.class,0);
		}
		public TerminalNode Varchar() { return getToken(GrammarParser.Varchar, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_literal);
		try {
			setState(291);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Null:
				enterOuterAlt(_localctx, 1);
				{
				setState(288);
				match(Null);
				}
				break;
			case Digit:
				enterOuterAlt(_localctx, 2);
				{
				setState(289);
				integer();
				}
				break;
			case Varchar:
				enterOuterAlt(_localctx, 3);
				{
				setState(290);
				match(Varchar);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3,\u0128\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\3\2\3\2\7\2I\n\2\f\2\16\2L\13\2\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\5\3W\n\3\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7"+
		"\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n|\n\n\f\n\16\n\177\13\n\3\n\3\n\3\n\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u008b\n\13\f\13\16\13\u008e\13\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u0097\n\13\3\f\3\f\3\f\3\f\3"+
		"\f\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u00a4\n\r\f\r\16\r\u00a7\13\r\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\5\16\u00af\n\16\3\17\3\17\7\17\u00b3\n\17\f\17\16"+
		"\17\u00b6\13\17\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\5\22\u00c7\n\22\3\23\3\23\3\23\3\23\3\23\5\23\u00ce"+
		"\n\23\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\31"+
		"\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\33\3\33\3\33\7\33\u00f5\n\33\f\33"+
		"\16\33\u00f8\13\33\3\34\3\34\3\34\7\34\u00fd\n\34\f\34\16\34\u0100\13"+
		"\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\5\35\u010a\n\35\3\36\3\36"+
		"\3\36\7\36\u010f\n\36\f\36\16\36\u0112\13\36\3\37\3\37\7\37\u0116\n\37"+
		"\f\37\16\37\u0119\13\37\3 \3 \3!\3!\5!\u011f\n!\3\"\3\"\3#\3#\3#\5#\u0126"+
		"\n#\3#\2\2$\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\66"+
		"8:<>@BD\2\4\3\2()\3\2\"\'\2\u0125\2J\3\2\2\2\4V\3\2\2\2\6X\3\2\2\2\b["+
		"\3\2\2\2\n^\3\2\2\2\fa\3\2\2\2\16c\3\2\2\2\20f\3\2\2\2\22p\3\2\2\2\24"+
		"\u0096\3\2\2\2\26\u0098\3\2\2\2\30\u009d\3\2\2\2\32\u00ae\3\2\2\2\34\u00b0"+
		"\3\2\2\2\36\u00b7\3\2\2\2 \u00bc\3\2\2\2\"\u00c6\3\2\2\2$\u00cd\3\2\2"+
		"\2&\u00cf\3\2\2\2(\u00d5\3\2\2\2*\u00db\3\2\2\2,\u00e1\3\2\2\2.\u00e5"+
		"\3\2\2\2\60\u00e9\3\2\2\2\62\u00ed\3\2\2\2\64\u00f1\3\2\2\2\66\u00f9\3"+
		"\2\2\28\u0109\3\2\2\2:\u010b\3\2\2\2<\u0113\3\2\2\2>\u011a\3\2\2\2@\u011e"+
		"\3\2\2\2B\u0120\3\2\2\2D\u0125\3\2\2\2FI\5\36\20\2GI\5\4\3\2HF\3\2\2\2"+
		"HG\3\2\2\2IL\3\2\2\2JH\3\2\2\2JK\3\2\2\2K\3\3\2\2\2LJ\3\2\2\2MW\5\6\4"+
		"\2NW\5\b\5\2OW\5\n\6\2PW\5\f\7\2QW\5\16\b\2RW\5\20\t\2SW\5\22\n\2TW\5"+
		"\24\13\2UW\5\26\f\2VM\3\2\2\2VN\3\2\2\2VO\3\2\2\2VP\3\2\2\2VQ\3\2\2\2"+
		"VR\3\2\2\2VS\3\2\2\2VT\3\2\2\2VU\3\2\2\2W\5\3\2\2\2XY\7\3\2\2YZ\5 \21"+
		"\2Z\7\3\2\2\2[\\\7\4\2\2\\]\5 \21\2]\t\3\2\2\2^_\7\5\2\2_`\5 \21\2`\13"+
		"\3\2\2\2ab\7\6\2\2b\r\3\2\2\2cd\7\7\2\2de\5$\23\2e\17\3\2\2\2fg\7\b\2"+
		"\2gh\5 \21\2hi\7\t\2\2ij\5\30\r\2jk\7\n\2\2kl\7\13\2\2lm\7\t\2\2mn\5:"+
		"\36\2no\7\n\2\2o\21\3\2\2\2pq\7\f\2\2qr\5 \21\2rs\7\r\2\2st\5B\"\2tu\7"+
		"\16\2\2u}\5D#\2vw\7\17\2\2wx\5B\"\2xy\7\16\2\2yz\5D#\2z|\3\2\2\2{v\3\2"+
		"\2\2|\177\3\2\2\2}{\3\2\2\2}~\3\2\2\2~\u0080\3\2\2\2\177}\3\2\2\2\u0080"+
		"\u0081\7\20\2\2\u0081\u0082\5\64\33\2\u0082\23\3\2\2\2\u0083\u0084\7\21"+
		"\2\2\u0084\u0085\5 \21\2\u0085\u0086\7\22\2\2\u0086\u0087\7\t\2\2\u0087"+
		"\u008c\5D#\2\u0088\u0089\7\17\2\2\u0089\u008b\5D#\2\u008a\u0088\3\2\2"+
		"\2\u008b\u008e\3\2\2\2\u008c\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008f"+
		"\3\2\2\2\u008e\u008c\3\2\2\2\u008f\u0090\7\n\2\2\u0090\u0097\3\2\2\2\u0091"+
		"\u0092\7\21\2\2\u0092\u0093\5 \21\2\u0093\u0094\7\23\2\2\u0094\u0095\5"+
		"\"\22\2\u0095\u0097\3\2\2\2\u0096\u0083\3\2\2\2\u0096\u0091\3\2\2\2\u0097"+
		"\25\3\2\2\2\u0098\u0099\7\24\2\2\u0099\u009a\5 \21\2\u009a\u009b\7\20"+
		"\2\2\u009b\u009c\5\64\33\2\u009c\27\3\2\2\2\u009d\u009e\5B\"\2\u009e\u00a5"+
		"\5\32\16\2\u009f\u00a0\7\17\2\2\u00a0\u00a1\5B\"\2\u00a1\u00a2\5\32\16"+
		"\2\u00a2\u00a4\3\2\2\2\u00a3\u009f\3\2\2\2\u00a4\u00a7\3\2\2\2\u00a5\u00a3"+
		"\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\31\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a8"+
		"\u00a9\7\25\2\2\u00a9\u00aa\7\t\2\2\u00aa\u00ab\5\34\17\2\u00ab\u00ac"+
		"\7\n\2\2\u00ac\u00af\3\2\2\2\u00ad\u00af\7\26\2\2\u00ae\u00a8\3\2\2\2"+
		"\u00ae\u00ad\3\2\2\2\u00af\33\3\2\2\2\u00b0\u00b4\7)\2\2\u00b1\u00b3\7"+
		")\2\2\u00b2\u00b1\3\2\2\2\u00b3\u00b6\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b4"+
		"\u00b5\3\2\2\2\u00b5\35\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b7\u00b8\5 \21"+
		"\2\u00b8\u00b9\7\27\2\2\u00b9\u00ba\5\"\22\2\u00ba\u00bb\7\30\2\2\u00bb"+
		"\37\3\2\2\2\u00bc\u00bd\5<\37\2\u00bd!\3\2\2\2\u00be\u00c7\5$\23\2\u00bf"+
		"\u00c7\5&\24\2\u00c0\u00c7\5(\25\2\u00c1\u00c7\5*\26\2\u00c2\u00c7\5,"+
		"\27\2\u00c3\u00c7\5.\30\2\u00c4\u00c7\5\60\31\2\u00c5\u00c7\5\62\32\2"+
		"\u00c6\u00be\3\2\2\2\u00c6\u00bf\3\2\2\2\u00c6\u00c0\3\2\2\2\u00c6\u00c1"+
		"\3\2\2\2\u00c6\u00c2\3\2\2\2\u00c6\u00c3\3\2\2\2\u00c6\u00c4\3\2\2\2\u00c6"+
		"\u00c5\3\2\2\2\u00c7#\3\2\2\2\u00c8\u00ce\5 \21\2\u00c9\u00ca\7\t\2\2"+
		"\u00ca\u00cb\5\"\22\2\u00cb\u00cc\7\n\2\2\u00cc\u00ce\3\2\2\2\u00cd\u00c8"+
		"\3\2\2\2\u00cd\u00c9\3\2\2\2\u00ce%\3\2\2\2\u00cf\u00d0\7\31\2\2\u00d0"+
		"\u00d1\7\t\2\2\u00d1\u00d2\5\64\33\2\u00d2\u00d3\7\n\2\2\u00d3\u00d4\5"+
		"$\23\2\u00d4\'\3\2\2\2\u00d5\u00d6\7\32\2\2\u00d6\u00d7\7\t\2\2\u00d7"+
		"\u00d8\5:\36\2\u00d8\u00d9\7\n\2\2\u00d9\u00da\5$\23\2\u00da)\3\2\2\2"+
		"\u00db\u00dc\7\33\2\2\u00dc\u00dd\7\t\2\2\u00dd\u00de\5:\36\2\u00de\u00df"+
		"\7\n\2\2\u00df\u00e0\5$\23\2\u00e0+\3\2\2\2\u00e1\u00e2\5$\23\2\u00e2"+
		"\u00e3\7\34\2\2\u00e3\u00e4\5$\23\2\u00e4-\3\2\2\2\u00e5\u00e6\5$\23\2"+
		"\u00e6\u00e7\7\35\2\2\u00e7\u00e8\5$\23\2\u00e8/\3\2\2\2\u00e9\u00ea\5"+
		"$\23\2\u00ea\u00eb\7\36\2\2\u00eb\u00ec\5$\23\2\u00ec\61\3\2\2\2\u00ed"+
		"\u00ee\5$\23\2\u00ee\u00ef\7\37\2\2\u00ef\u00f0\5$\23\2\u00f0\63\3\2\2"+
		"\2\u00f1\u00f6\5\66\34\2\u00f2\u00f3\7 \2\2\u00f3\u00f5\5\66\34\2\u00f4"+
		"\u00f2\3\2\2\2\u00f5\u00f8\3\2\2\2\u00f6\u00f4\3\2\2\2\u00f6\u00f7\3\2"+
		"\2\2\u00f7\65\3\2\2\2\u00f8\u00f6\3\2\2\2\u00f9\u00fe\58\35\2\u00fa\u00fb"+
		"\7!\2\2\u00fb\u00fd\58\35\2\u00fc\u00fa\3\2\2\2\u00fd\u0100\3\2\2\2\u00fe"+
		"\u00fc\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff\67\3\2\2\2\u0100\u00fe\3\2\2"+
		"\2\u0101\u0102\5@!\2\u0102\u0103\5> \2\u0103\u0104\5@!\2\u0104\u010a\3"+
		"\2\2\2\u0105\u0106\7\t\2\2\u0106\u0107\5\64\33\2\u0107\u0108\7\n\2\2\u0108"+
		"\u010a\3\2\2\2\u0109\u0101\3\2\2\2\u0109\u0105\3\2\2\2\u010a9\3\2\2\2"+
		"\u010b\u0110\5B\"\2\u010c\u010d\7\17\2\2\u010d\u010f\5B\"\2\u010e\u010c"+
		"\3\2\2\2\u010f\u0112\3\2\2\2\u0110\u010e\3\2\2\2\u0110\u0111\3\2\2\2\u0111"+
		";\3\2\2\2\u0112\u0110\3\2\2\2\u0113\u0117\7(\2\2\u0114\u0116\t\2\2\2\u0115"+
		"\u0114\3\2\2\2\u0116\u0119\3\2\2\2\u0117\u0115\3\2\2\2\u0117\u0118\3\2"+
		"\2\2\u0118=\3\2\2\2\u0119\u0117\3\2\2\2\u011a\u011b\t\3\2\2\u011b?\3\2"+
		"\2\2\u011c\u011f\5B\"\2\u011d\u011f\5D#\2\u011e\u011c\3\2\2\2\u011e\u011d"+
		"\3\2\2\2\u011fA\3\2\2\2\u0120\u0121\5<\37\2\u0121C\3\2\2\2\u0122\u0126"+
		"\7*\2\2\u0123\u0126\5\34\17\2\u0124\u0126\7+\2\2\u0125\u0122\3\2\2\2\u0125"+
		"\u0123\3\2\2\2\u0125\u0124\3\2\2\2\u0126E\3\2\2\2\24HJV}\u008c\u0096\u00a5"+
		"\u00ae\u00b4\u00c6\u00cd\u00f6\u00fe\u0109\u0110\u0117\u011e\u0125";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}