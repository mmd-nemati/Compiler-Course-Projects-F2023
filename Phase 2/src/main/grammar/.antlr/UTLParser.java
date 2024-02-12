// Generated from f:/Program Files (x86)/MMD.Soor/University/Term 5/PLC/PLC-CA/PLC_Phase2/src/main/grammar/UTL.g4 by ANTLR 4.13.1

    import main.ast.node.*;
    import main.ast.node.declaration.*;
    import main.ast.node.statement.*;
    import main.ast.node.expression.*;
    import main.ast.node.expression.operators.*;
    import main.ast.node.expression.values.*;
    import main.ast.type.primitiveType.*;
    import main.ast.type.complexType.*;
    import main.ast.type.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class UTLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SPACES=1, SEMICOLON=2, COMMA=3, COLON=4, DOT=5, LPAREN=6, RPAREN=7, LBRACE=8, 
		RBRACE=9, LBRACK=10, RBRACK=11, PLUS=12, MINUS=13, MULT=14, DIV=15, MOD=16, 
		AND=17, OR=18, NOT=19, BIT_AND=20, BIT_OR=21, BIT_XOR=22, L_SHIFT=23, 
		R_SHIFT=24, BIT_NOT=25, LT=26, GT=27, EQ=28, NEQ=29, INC=30, DEC=31, ASSIGN=32, 
		ADD_ASSIGN=33, SUB_ASSIGN=34, MUL_ASSIGN=35, DIV_ASSIGN=36, MOD_ASSIGN=37, 
		TRY=38, THROW=39, CATCH=40, IF=41, ELSE=42, FOR=43, WHILE=44, BREAK=45, 
		CONTINUE=46, RETURN=47, MAIN=48, ONINIT=49, ONSTART=50, FLOAT=51, DOUBLE=52, 
		STRING=53, BOOL=54, VOID=55, INT=56, BUY=57, SELL=58, ASK=59, BID=60, 
		TIME=61, HIGH=62, LOW=63, DIGITS=64, VOLUME=65, TYPE=66, TEXT=67, OPEN=68, 
		CLOSE=69, TRADE=70, ORDER=71, CANDLE=72, EXCEPTION=73, REFRESH_RATE=74, 
		GET_CANDLE=75, TERMINATE=76, CONNECT=77, OBSERVE=78, PRINT=79, ID=80, 
		INT_LITERAL=81, FLOAT_LITERAL=82, STRING_LITERAL=83, BOOL_LITERAL=84, 
		COMMENT=85;
	public static final int
		RULE_program = 0, RULE_statement = 1, RULE_globalVarDeclaration = 2, RULE_varDeclaration = 3, 
		RULE_functionDeclaration = 4, RULE_identifier = 5, RULE_mainDeclaration = 6, 
		RULE_initDeclaration = 7, RULE_startDeclaration = 8, RULE_assignStatement = 9, 
		RULE_ifStatement = 10, RULE_whileStatement = 11, RULE_forStatement = 12, 
		RULE_tryCatchStatement = 13, RULE_continueBreakStatement = 14, RULE_returnStatement = 15, 
		RULE_throwStatement = 16, RULE_functionCall = 17, RULE_methodCall = 18, 
		RULE_expression = 19, RULE_value = 20, RULE_primitiveType = 21, RULE_complexType = 22, 
		RULE_allType = 23, RULE_specialFunction = 24, RULE_specialVariable = 25, 
		RULE_specialMethod = 26, RULE_assign = 27;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "statement", "globalVarDeclaration", "varDeclaration", "functionDeclaration", 
			"identifier", "mainDeclaration", "initDeclaration", "startDeclaration", 
			"assignStatement", "ifStatement", "whileStatement", "forStatement", "tryCatchStatement", 
			"continueBreakStatement", "returnStatement", "throwStatement", "functionCall", 
			"methodCall", "expression", "value", "primitiveType", "complexType", 
			"allType", "specialFunction", "specialVariable", "specialMethod", "assign"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, "';'", "','", "':'", "'.'", "'('", "')'", "'{'", "'}'", "'['", 
			"']'", "'+'", "'-'", "'*'", "'/'", "'%'", "'&&'", "'||'", "'!'", "'&'", 
			"'|'", "'^'", "'<<'", "'>>'", "'~'", "'<'", "'>'", "'=='", "'!='", "'++'", 
			"'--'", "'='", "'+='", "'-='", "'*='", "'/='", "'%='", "'try'", "'throw'", 
			"'catch'", "'if'", "'else'", "'for'", "'while'", "'break'", "'continue'", 
			"'return'", "'Main'", "'OnInit'", "'OnStart'", "'float'", "'double'", 
			"'string'", "'bool'", "'void'", "'int'", "'BUY'", "'SELL'", "'Ask'", 
			"'Bid'", "'Time'", "'High'", "'Low'", "'Digits'", "'Volume'", "'Type'", 
			"'Text'", "'Open'", "'Close'", "'Trade'", "'Order'", "'Candle'", "'Exception'", 
			"'RefreshRate'", "'GetCandle'", "'Terminate'", "'Connect'", "'Observe'", 
			"'Print'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "SPACES", "SEMICOLON", "COMMA", "COLON", "DOT", "LPAREN", "RPAREN", 
			"LBRACE", "RBRACE", "LBRACK", "RBRACK", "PLUS", "MINUS", "MULT", "DIV", 
			"MOD", "AND", "OR", "NOT", "BIT_AND", "BIT_OR", "BIT_XOR", "L_SHIFT", 
			"R_SHIFT", "BIT_NOT", "LT", "GT", "EQ", "NEQ", "INC", "DEC", "ASSIGN", 
			"ADD_ASSIGN", "SUB_ASSIGN", "MUL_ASSIGN", "DIV_ASSIGN", "MOD_ASSIGN", 
			"TRY", "THROW", "CATCH", "IF", "ELSE", "FOR", "WHILE", "BREAK", "CONTINUE", 
			"RETURN", "MAIN", "ONINIT", "ONSTART", "FLOAT", "DOUBLE", "STRING", "BOOL", 
			"VOID", "INT", "BUY", "SELL", "ASK", "BID", "TIME", "HIGH", "LOW", "DIGITS", 
			"VOLUME", "TYPE", "TEXT", "OPEN", "CLOSE", "TRADE", "ORDER", "CANDLE", 
			"EXCEPTION", "REFRESH_RATE", "GET_CANDLE", "TERMINATE", "CONNECT", "OBSERVE", 
			"PRINT", "ID", "INT_LITERAL", "FLOAT_LITERAL", "STRING_LITERAL", "BOOL_LITERAL", 
			"COMMENT"
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
	public String getGrammarFileName() { return "UTL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public UTLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public Program pro;
		public GlobalVarDeclarationContext globalVarDeclaration;
		public FunctionDeclarationContext functionDeclaration;
		public InitDeclarationContext initDeclaration;
		public StartDeclarationContext startDeclaration;
		public MainDeclarationContext mainDeclaration;
		public MainDeclarationContext mainDeclaration() {
			return getRuleContext(MainDeclarationContext.class,0);
		}
		public List<GlobalVarDeclarationContext> globalVarDeclaration() {
			return getRuleContexts(GlobalVarDeclarationContext.class);
		}
		public GlobalVarDeclarationContext globalVarDeclaration(int i) {
			return getRuleContext(GlobalVarDeclarationContext.class,i);
		}
		public List<FunctionDeclarationContext> functionDeclaration() {
			return getRuleContexts(FunctionDeclarationContext.class);
		}
		public FunctionDeclarationContext functionDeclaration(int i) {
			return getRuleContext(FunctionDeclarationContext.class,i);
		}
		public List<InitDeclarationContext> initDeclaration() {
			return getRuleContexts(InitDeclarationContext.class);
		}
		public InitDeclarationContext initDeclaration(int i) {
			return getRuleContext(InitDeclarationContext.class,i);
		}
		public List<StartDeclarationContext> startDeclaration() {
			return getRuleContexts(StartDeclarationContext.class);
		}
		public StartDeclarationContext startDeclaration(int i) {
			return getRuleContext(StartDeclarationContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTLListener ) ((UTLListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTLListener ) ((UTLListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			((ProgramContext)_localctx).pro =  new Program(); _localctx.pro.setLine(0);
			setState(71);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(69);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
					case 1:
						{
						setState(57);
						((ProgramContext)_localctx).globalVarDeclaration = globalVarDeclaration();
						 _localctx.pro.addGlobalVar(((ProgramContext)_localctx).globalVarDeclaration.globalVarDecRet); 
						}
						break;
					case 2:
						{
						setState(60);
						((ProgramContext)_localctx).functionDeclaration = functionDeclaration();
						 _localctx.pro.addFunction(((ProgramContext)_localctx).functionDeclaration.funcDecRet); 
						}
						break;
					case 3:
						{
						setState(63);
						((ProgramContext)_localctx).initDeclaration = initDeclaration();
						 _localctx.pro.addInit(((ProgramContext)_localctx).initDeclaration.initDecRet); 
						}
						break;
					case 4:
						{
						setState(66);
						((ProgramContext)_localctx).startDeclaration = startDeclaration();
						 _localctx.pro.addStart(((ProgramContext)_localctx).startDeclaration.startDecRet); 
						}
						break;
					}
					} 
				}
				setState(73);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(74);
			((ProgramContext)_localctx).mainDeclaration = mainDeclaration();
			 _localctx.pro.setMain(((ProgramContext)_localctx).mainDeclaration.mainDecRet); 
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

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public Statement statementRet;
		public VarDeclarationContext varDeclaration;
		public FunctionDeclarationContext functionDeclaration;
		public AssignStatementContext assignStatement;
		public ContinueBreakStatementContext continueBreakStatement;
		public ReturnStatementContext returnStatement;
		public IfStatementContext ifStatement;
		public WhileStatementContext whileStatement;
		public ForStatementContext forStatement;
		public TryCatchStatementContext tryCatchStatement;
		public ThrowStatementContext throwStatement;
		public ExpressionContext expression;
		public VarDeclarationContext varDeclaration() {
			return getRuleContext(VarDeclarationContext.class,0);
		}
		public FunctionDeclarationContext functionDeclaration() {
			return getRuleContext(FunctionDeclarationContext.class,0);
		}
		public AssignStatementContext assignStatement() {
			return getRuleContext(AssignStatementContext.class,0);
		}
		public ContinueBreakStatementContext continueBreakStatement() {
			return getRuleContext(ContinueBreakStatementContext.class,0);
		}
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public WhileStatementContext whileStatement() {
			return getRuleContext(WhileStatementContext.class,0);
		}
		public ForStatementContext forStatement() {
			return getRuleContext(ForStatementContext.class,0);
		}
		public TryCatchStatementContext tryCatchStatement() {
			return getRuleContext(TryCatchStatementContext.class,0);
		}
		public ThrowStatementContext throwStatement() {
			return getRuleContext(ThrowStatementContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(UTLParser.SEMICOLON, 0); }
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTLListener ) ((UTLListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTLListener ) ((UTLListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(77);
				((StatementContext)_localctx).varDeclaration = varDeclaration();
				 ((StatementContext)_localctx).statementRet =  ((StatementContext)_localctx).varDeclaration.varDecRet; 
				}
				break;
			case 2:
				{
				setState(80);
				((StatementContext)_localctx).functionDeclaration = functionDeclaration();
				 ((StatementContext)_localctx).statementRet =  ((StatementContext)_localctx).functionDeclaration.funcDecRet; 
				}
				break;
			case 3:
				{
				setState(83);
				((StatementContext)_localctx).assignStatement = assignStatement();
				 ((StatementContext)_localctx).statementRet =  ((StatementContext)_localctx).assignStatement.assignStmtRet; 
				}
				break;
			case 4:
				{
				setState(86);
				((StatementContext)_localctx).continueBreakStatement = continueBreakStatement();
				 ((StatementContext)_localctx).statementRet =  ((StatementContext)_localctx).continueBreakStatement.continueBreakStmtRet; 
				}
				break;
			case 5:
				{
				setState(89);
				((StatementContext)_localctx).returnStatement = returnStatement();
				 ((StatementContext)_localctx).statementRet =  ((StatementContext)_localctx).returnStatement.returnStmtRet; 
				}
				break;
			case 6:
				{
				setState(92);
				((StatementContext)_localctx).ifStatement = ifStatement();
				 ((StatementContext)_localctx).statementRet =  ((StatementContext)_localctx).ifStatement.ifStmtRet; 
				}
				break;
			case 7:
				{
				setState(95);
				((StatementContext)_localctx).whileStatement = whileStatement();
				 ((StatementContext)_localctx).statementRet =  ((StatementContext)_localctx).whileStatement.whileStmtRet; 
				}
				break;
			case 8:
				{
				setState(98);
				((StatementContext)_localctx).forStatement = forStatement();
				 ((StatementContext)_localctx).statementRet =  ((StatementContext)_localctx).forStatement.forStmtRet; 
				}
				break;
			case 9:
				{
				setState(101);
				((StatementContext)_localctx).tryCatchStatement = tryCatchStatement();
				 ((StatementContext)_localctx).statementRet =  ((StatementContext)_localctx).tryCatchStatement.tryCatchStmtRet; 
				}
				break;
			case 10:
				{
				setState(104);
				((StatementContext)_localctx).throwStatement = throwStatement();
				 ((StatementContext)_localctx).statementRet =  ((StatementContext)_localctx).throwStatement.throwStmtRet; 
				}
				break;
			case 11:
				{
				setState(107);
				((StatementContext)_localctx).expression = expression(0);
				setState(108);
				match(SEMICOLON);
				 ((StatementContext)_localctx).statementRet =  new ExpressionStmt(((StatementContext)_localctx).expression.expressionRet); 
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

	@SuppressWarnings("CheckReturnValue")
	public static class GlobalVarDeclarationContext extends ParserRuleContext {
		public GlobalVarDeclaration globalVarDecRet;
		public AllTypeContext allType;
		public Token INT_LITERAL;
		public IdentifierContext id;
		public ExpressionContext e;
		public AllTypeContext allType() {
			return getRuleContext(AllTypeContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(UTLParser.SEMICOLON, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode LBRACK() { return getToken(UTLParser.LBRACK, 0); }
		public TerminalNode INT_LITERAL() { return getToken(UTLParser.INT_LITERAL, 0); }
		public TerminalNode RBRACK() { return getToken(UTLParser.RBRACK, 0); }
		public TerminalNode ASSIGN() { return getToken(UTLParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public GlobalVarDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_globalVarDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTLListener ) ((UTLListener)listener).enterGlobalVarDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTLListener ) ((UTLListener)listener).exitGlobalVarDeclaration(this);
		}
	}

	public final GlobalVarDeclarationContext globalVarDeclaration() throws RecognitionException {
		GlobalVarDeclarationContext _localctx = new GlobalVarDeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_globalVarDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((GlobalVarDeclarationContext)_localctx).globalVarDecRet =  new GlobalVarDeclaration(); 
			setState(114);
			((GlobalVarDeclarationContext)_localctx).allType = allType();
			 _localctx.globalVarDecRet.setType(((GlobalVarDeclarationContext)_localctx).allType.allTypeRet); 
			setState(120);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACK) {
				{
				setState(116);
				match(LBRACK);
				setState(117);
				((GlobalVarDeclarationContext)_localctx).INT_LITERAL = match(INT_LITERAL);
				setState(118);
				match(RBRACK);
				 _localctx.globalVarDecRet.setLength((((GlobalVarDeclarationContext)_localctx).INT_LITERAL!=null?Integer.valueOf(((GlobalVarDeclarationContext)_localctx).INT_LITERAL.getText()):0)); 
				}
			}

			setState(122);
			((GlobalVarDeclarationContext)_localctx).id = identifier();
			setState(127);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(123);
				match(ASSIGN);
				setState(124);
				((GlobalVarDeclarationContext)_localctx).e = expression(0);
				 _localctx.globalVarDecRet.setValue(((GlobalVarDeclarationContext)_localctx).e.expressionRet); 
				}
			}

			setState(129);
			match(SEMICOLON);

			        _localctx.globalVarDecRet.setIdentifier(((GlobalVarDeclarationContext)_localctx).id.idRet);
			        _localctx.globalVarDecRet.setLine(((GlobalVarDeclarationContext)_localctx).id.idRet.getLine());
			    
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

	@SuppressWarnings("CheckReturnValue")
	public static class VarDeclarationContext extends ParserRuleContext {
		public VarDeclaration varDecRet;
		public AllTypeContext allType;
		public Token INT_LITERAL;
		public IdentifierContext id;
		public ExpressionContext e;
		public AllTypeContext allType() {
			return getRuleContext(AllTypeContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(UTLParser.SEMICOLON, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode LBRACK() { return getToken(UTLParser.LBRACK, 0); }
		public TerminalNode INT_LITERAL() { return getToken(UTLParser.INT_LITERAL, 0); }
		public TerminalNode RBRACK() { return getToken(UTLParser.RBRACK, 0); }
		public TerminalNode ASSIGN() { return getToken(UTLParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VarDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTLListener ) ((UTLListener)listener).enterVarDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTLListener ) ((UTLListener)listener).exitVarDeclaration(this);
		}
	}

	public final VarDeclarationContext varDeclaration() throws RecognitionException {
		VarDeclarationContext _localctx = new VarDeclarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_varDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((VarDeclarationContext)_localctx).varDecRet =  new VarDeclaration(); 
			setState(133);
			((VarDeclarationContext)_localctx).allType = allType();
			 _localctx.varDecRet.setType(((VarDeclarationContext)_localctx).allType.allTypeRet); 
			setState(139);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACK) {
				{
				setState(135);
				match(LBRACK);
				setState(136);
				((VarDeclarationContext)_localctx).INT_LITERAL = match(INT_LITERAL);
				setState(137);
				match(RBRACK);
				 _localctx.varDecRet.setLength((((VarDeclarationContext)_localctx).INT_LITERAL!=null?Integer.valueOf(((VarDeclarationContext)_localctx).INT_LITERAL.getText()):0)); 
				}
			}

			setState(141);
			((VarDeclarationContext)_localctx).id = identifier();
			setState(146);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(142);
				match(ASSIGN);
				setState(143);
				((VarDeclarationContext)_localctx).e = expression(0);
				 _localctx.varDecRet.setValue(((VarDeclarationContext)_localctx).e.expressionRet); 
				}
			}

			setState(148);
			match(SEMICOLON);

			        _localctx.varDecRet.setIdentifier(((VarDeclarationContext)_localctx).id.idRet);
			        _localctx.varDecRet.setLine(((VarDeclarationContext)_localctx).id.idRet.getLine());
			    
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

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionDeclarationContext extends ParserRuleContext {
		public FunctionDeclaration funcDecRet;
		public PrimitiveTypeContext primitiveType;
		public IdentifierContext funcName;
		public AllTypeContext allType;
		public Token INT_LITERAL;
		public IdentifierContext argName;
		public StatementContext statement;
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(UTLParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(UTLParser.RPAREN, 0); }
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode LBRACE() { return getToken(UTLParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(UTLParser.RBRACE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<AllTypeContext> allType() {
			return getRuleContexts(AllTypeContext.class);
		}
		public AllTypeContext allType(int i) {
			return getRuleContext(AllTypeContext.class,i);
		}
		public TerminalNode THROW() { return getToken(UTLParser.THROW, 0); }
		public TerminalNode EXCEPTION() { return getToken(UTLParser.EXCEPTION, 0); }
		public List<TerminalNode> LBRACK() { return getTokens(UTLParser.LBRACK); }
		public TerminalNode LBRACK(int i) {
			return getToken(UTLParser.LBRACK, i);
		}
		public List<TerminalNode> INT_LITERAL() { return getTokens(UTLParser.INT_LITERAL); }
		public TerminalNode INT_LITERAL(int i) {
			return getToken(UTLParser.INT_LITERAL, i);
		}
		public List<TerminalNode> RBRACK() { return getTokens(UTLParser.RBRACK); }
		public TerminalNode RBRACK(int i) {
			return getToken(UTLParser.RBRACK, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(UTLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(UTLParser.COMMA, i);
		}
		public FunctionDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTLListener ) ((UTLListener)listener).enterFunctionDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTLListener ) ((UTLListener)listener).exitFunctionDeclaration(this);
		}
	}

	public final FunctionDeclarationContext functionDeclaration() throws RecognitionException {
		FunctionDeclarationContext _localctx = new FunctionDeclarationContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_functionDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((FunctionDeclarationContext)_localctx).funcDecRet =  new FunctionDeclaration(); 
			setState(152);
			((FunctionDeclarationContext)_localctx).primitiveType = primitiveType();
			 _localctx.funcDecRet.setReturnType(((FunctionDeclarationContext)_localctx).primitiveType.primitiveTypeRet); 
			setState(154);
			((FunctionDeclarationContext)_localctx).funcName = identifier();
			 _localctx.funcDecRet.setName(((FunctionDeclarationContext)_localctx).funcName.idRet); _localctx.funcDecRet.setLine(((FunctionDeclarationContext)_localctx).funcName.idRet.getLine()); 
			setState(156);
			match(LPAREN);
			setState(184);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 51)) & ~0x3f) == 0 && ((1L << (_la - 51)) & 7864383L) != 0)) {
				{
				setState(157);
				((FunctionDeclarationContext)_localctx).allType = allType();
				 VarDeclaration arg = new VarDeclaration(); 
				setState(163);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LBRACK) {
					{
					setState(159);
					match(LBRACK);
					setState(160);
					((FunctionDeclarationContext)_localctx).INT_LITERAL = match(INT_LITERAL);
					setState(161);
					match(RBRACK);
					 arg.setLength((((FunctionDeclarationContext)_localctx).INT_LITERAL!=null?Integer.valueOf(((FunctionDeclarationContext)_localctx).INT_LITERAL.getText()):0)); 
					}
				}

				setState(165);
				((FunctionDeclarationContext)_localctx).argName = identifier();
				 arg.setType(((FunctionDeclarationContext)_localctx).allType.allTypeRet);
				                                   arg.setIdentifier(((FunctionDeclarationContext)_localctx).argName.idRet);
				                                   arg.setLine(((FunctionDeclarationContext)_localctx).argName.idRet.getLine());
				                                   _localctx.funcDecRet.addArg(arg);
				                                 
				setState(181);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(167);
					match(COMMA);
					setState(168);
					((FunctionDeclarationContext)_localctx).allType = allType();
					 arg = new VarDeclaration(); 
					setState(174);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==LBRACK) {
						{
						setState(170);
						match(LBRACK);
						setState(171);
						((FunctionDeclarationContext)_localctx).INT_LITERAL = match(INT_LITERAL);
						setState(172);
						match(RBRACK);
						 arg.setLength((((FunctionDeclarationContext)_localctx).INT_LITERAL!=null?Integer.valueOf(((FunctionDeclarationContext)_localctx).INT_LITERAL.getText()):0)); 
						}
					}

					setState(176);
					((FunctionDeclarationContext)_localctx).argName = identifier();
					 arg.setType(((FunctionDeclarationContext)_localctx).allType.allTypeRet);
					                                   arg.setIdentifier(((FunctionDeclarationContext)_localctx).argName.idRet);
					                                   _localctx.funcDecRet.addArg(arg);  
					}
					}
					setState(183);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(186);
			match(RPAREN);
			setState(189);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(187);
				match(THROW);
				setState(188);
				match(EXCEPTION);
				}
				break;
			}
			setState(204);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
				{
				setState(191);
				match(LBRACE);
				setState(197);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 574484658285715520L) != 0) || ((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & 32767L) != 0)) {
					{
					{
					setState(192);
					((FunctionDeclarationContext)_localctx).statement = statement();
					 _localctx.funcDecRet.addStatement(((FunctionDeclarationContext)_localctx).statement.statementRet); 
					}
					}
					setState(199);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(200);
				match(RBRACE);
				}
				break;
			case LPAREN:
			case MINUS:
			case NOT:
			case BIT_NOT:
			case INC:
			case DEC:
			case TRY:
			case THROW:
			case IF:
			case FOR:
			case WHILE:
			case BREAK:
			case CONTINUE:
			case RETURN:
			case FLOAT:
			case DOUBLE:
			case STRING:
			case BOOL:
			case VOID:
			case INT:
			case BUY:
			case SELL:
			case TRADE:
			case ORDER:
			case CANDLE:
			case EXCEPTION:
			case REFRESH_RATE:
			case GET_CANDLE:
			case TERMINATE:
			case CONNECT:
			case OBSERVE:
			case PRINT:
			case ID:
			case INT_LITERAL:
			case FLOAT_LITERAL:
			case STRING_LITERAL:
			case BOOL_LITERAL:
				{
				setState(201);
				((FunctionDeclarationContext)_localctx).statement = statement();
				 _localctx.funcDecRet.addStatement(((FunctionDeclarationContext)_localctx).statement.statementRet); 
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

	@SuppressWarnings("CheckReturnValue")
	public static class IdentifierContext extends ParserRuleContext {
		public Identifier idRet;
		public Token ID;
		public TerminalNode ID() { return getToken(UTLParser.ID, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTLListener ) ((UTLListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTLListener ) ((UTLListener)listener).exitIdentifier(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			((IdentifierContext)_localctx).ID = match(ID);
			 ((IdentifierContext)_localctx).idRet =  new Identifier((((IdentifierContext)_localctx).ID!=null?((IdentifierContext)_localctx).ID.getText():null)); _localctx.idRet.setLine((((IdentifierContext)_localctx).ID!=null?((IdentifierContext)_localctx).ID.getLine():0)); 
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

	@SuppressWarnings("CheckReturnValue")
	public static class MainDeclarationContext extends ParserRuleContext {
		public MainDeclaration mainDecRet;
		public Token MAIN;
		public StatementContext s;
		public TerminalNode VOID() { return getToken(UTLParser.VOID, 0); }
		public TerminalNode MAIN() { return getToken(UTLParser.MAIN, 0); }
		public TerminalNode LPAREN() { return getToken(UTLParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(UTLParser.RPAREN, 0); }
		public TerminalNode LBRACE() { return getToken(UTLParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(UTLParser.RBRACE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public MainDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mainDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTLListener ) ((UTLListener)listener).enterMainDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTLListener ) ((UTLListener)listener).exitMainDeclaration(this);
		}
	}

	public final MainDeclarationContext mainDeclaration() throws RecognitionException {
		MainDeclarationContext _localctx = new MainDeclarationContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_mainDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((MainDeclarationContext)_localctx).mainDecRet =  new MainDeclaration(); 
			setState(210);
			match(VOID);
			setState(211);
			((MainDeclarationContext)_localctx).MAIN = match(MAIN);
			 _localctx.mainDecRet.setLine((((MainDeclarationContext)_localctx).MAIN!=null?((MainDeclarationContext)_localctx).MAIN.getLine():0)); 
			setState(213);
			match(LPAREN);
			setState(214);
			match(RPAREN);
			setState(228);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
				{
				setState(215);
				match(LBRACE);
				setState(221);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 574484658285715520L) != 0) || ((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & 32767L) != 0)) {
					{
					{
					setState(216);
					((MainDeclarationContext)_localctx).s = statement();

					       if (((MainDeclarationContext)_localctx).s.statementRet instanceof VarDeclaration)
					       {
					           if (((MainDeclarationContext)_localctx).s.statementRet.getType() instanceof TradeType)
					           {
					                VarDeclaration tradeDec = new VarDeclaration();
					                tradeDec.setIdentifier(((MainDeclarationContext)_localctx).s.statementRet.getIdentifier());
					                tradeDec.setType(((MainDeclarationContext)_localctx).s.statementRet.getType());
					                tradeDec.setLine(((MainDeclarationContext)_localctx).s.statementRet.getLine());
					                _localctx.mainDecRet.addTradeInstantiation(tradeDec);
					           }
					           else
					               _localctx.mainDecRet.addStatement(((MainDeclarationContext)_localctx).s.statementRet);
					       }
					       else
					           _localctx.mainDecRet.addStatement(((MainDeclarationContext)_localctx).s.statementRet);
					     
					}
					}
					setState(223);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(224);
				match(RBRACE);
				}
				break;
			case LPAREN:
			case MINUS:
			case NOT:
			case BIT_NOT:
			case INC:
			case DEC:
			case TRY:
			case THROW:
			case IF:
			case FOR:
			case WHILE:
			case BREAK:
			case CONTINUE:
			case RETURN:
			case FLOAT:
			case DOUBLE:
			case STRING:
			case BOOL:
			case VOID:
			case INT:
			case BUY:
			case SELL:
			case TRADE:
			case ORDER:
			case CANDLE:
			case EXCEPTION:
			case REFRESH_RATE:
			case GET_CANDLE:
			case TERMINATE:
			case CONNECT:
			case OBSERVE:
			case PRINT:
			case ID:
			case INT_LITERAL:
			case FLOAT_LITERAL:
			case STRING_LITERAL:
			case BOOL_LITERAL:
				{
				setState(225);
				((MainDeclarationContext)_localctx).s = statement();

				        if (((MainDeclarationContext)_localctx).s.statementRet instanceof VarDeclaration)
				        {
				           if (((MainDeclarationContext)_localctx).s.statementRet.getType() instanceof TradeType)
				           {
				                VarDeclaration tradeDec = new VarDeclaration();
				                tradeDec.setIdentifier(((MainDeclarationContext)_localctx).s.statementRet.getIdentifier());
				                tradeDec.setType(((MainDeclarationContext)_localctx).s.statementRet.getType());
				                tradeDec.setLine(((MainDeclarationContext)_localctx).s.statementRet.getLine());
				                _localctx.mainDecRet.addTradeInstantiation(tradeDec);
				           }
				            else
				                _localctx.mainDecRet.addStatement(((MainDeclarationContext)_localctx).s.statementRet);
				        }
				        else
				          _localctx.mainDecRet.addStatement(((MainDeclarationContext)_localctx).s.statementRet);
				    
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

	@SuppressWarnings("CheckReturnValue")
	public static class InitDeclarationContext extends ParserRuleContext {
		public OnInitDeclaration initDecRet;
		public Token ONINIT;
		public IdentifierContext tradeName;
		public StatementContext statement;
		public TerminalNode VOID() { return getToken(UTLParser.VOID, 0); }
		public TerminalNode ONINIT() { return getToken(UTLParser.ONINIT, 0); }
		public TerminalNode LPAREN() { return getToken(UTLParser.LPAREN, 0); }
		public TerminalNode TRADE() { return getToken(UTLParser.TRADE, 0); }
		public TerminalNode RPAREN() { return getToken(UTLParser.RPAREN, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode LBRACE() { return getToken(UTLParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(UTLParser.RBRACE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode THROW() { return getToken(UTLParser.THROW, 0); }
		public TerminalNode EXCEPTION() { return getToken(UTLParser.EXCEPTION, 0); }
		public InitDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTLListener ) ((UTLListener)listener).enterInitDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTLListener ) ((UTLListener)listener).exitInitDeclaration(this);
		}
	}

	public final InitDeclarationContext initDeclaration() throws RecognitionException {
		InitDeclarationContext _localctx = new InitDeclarationContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_initDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((InitDeclarationContext)_localctx).initDecRet =  new OnInitDeclaration(); 
			setState(231);
			match(VOID);
			setState(232);
			((InitDeclarationContext)_localctx).ONINIT = match(ONINIT);
			 _localctx.initDecRet.setLine((((InitDeclarationContext)_localctx).ONINIT!=null?((InitDeclarationContext)_localctx).ONINIT.getLine():0)); 
			setState(234);
			match(LPAREN);
			setState(235);
			match(TRADE);
			setState(236);
			((InitDeclarationContext)_localctx).tradeName = identifier();
			 _localctx.initDecRet.setTradeName(((InitDeclarationContext)_localctx).tradeName.idRet); 
			setState(238);
			match(RPAREN);
			setState(241);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(239);
				match(THROW);
				setState(240);
				match(EXCEPTION);
				}
				break;
			}
			setState(256);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
				{
				setState(243);
				match(LBRACE);
				setState(249);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 574484658285715520L) != 0) || ((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & 32767L) != 0)) {
					{
					{
					setState(244);
					((InitDeclarationContext)_localctx).statement = statement();
					 _localctx.initDecRet.addStatement(((InitDeclarationContext)_localctx).statement.statementRet); 
					}
					}
					setState(251);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(252);
				match(RBRACE);
				}
				break;
			case LPAREN:
			case MINUS:
			case NOT:
			case BIT_NOT:
			case INC:
			case DEC:
			case TRY:
			case THROW:
			case IF:
			case FOR:
			case WHILE:
			case BREAK:
			case CONTINUE:
			case RETURN:
			case FLOAT:
			case DOUBLE:
			case STRING:
			case BOOL:
			case VOID:
			case INT:
			case BUY:
			case SELL:
			case TRADE:
			case ORDER:
			case CANDLE:
			case EXCEPTION:
			case REFRESH_RATE:
			case GET_CANDLE:
			case TERMINATE:
			case CONNECT:
			case OBSERVE:
			case PRINT:
			case ID:
			case INT_LITERAL:
			case FLOAT_LITERAL:
			case STRING_LITERAL:
			case BOOL_LITERAL:
				{
				setState(253);
				((InitDeclarationContext)_localctx).statement = statement();
				 _localctx.initDecRet.addStatement(((InitDeclarationContext)_localctx).statement.statementRet); 
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

	@SuppressWarnings("CheckReturnValue")
	public static class StartDeclarationContext extends ParserRuleContext {
		public OnStartDeclaration startDecRet;
		public Token ONSTART;
		public IdentifierContext tradeName;
		public StatementContext statement;
		public TerminalNode VOID() { return getToken(UTLParser.VOID, 0); }
		public TerminalNode ONSTART() { return getToken(UTLParser.ONSTART, 0); }
		public TerminalNode LPAREN() { return getToken(UTLParser.LPAREN, 0); }
		public TerminalNode TRADE() { return getToken(UTLParser.TRADE, 0); }
		public TerminalNode RPAREN() { return getToken(UTLParser.RPAREN, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode LBRACE() { return getToken(UTLParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(UTLParser.RBRACE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode THROW() { return getToken(UTLParser.THROW, 0); }
		public TerminalNode EXCEPTION() { return getToken(UTLParser.EXCEPTION, 0); }
		public StartDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_startDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTLListener ) ((UTLListener)listener).enterStartDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTLListener ) ((UTLListener)listener).exitStartDeclaration(this);
		}
	}

	public final StartDeclarationContext startDeclaration() throws RecognitionException {
		StartDeclarationContext _localctx = new StartDeclarationContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_startDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(258);
			match(VOID);
			setState(259);
			((StartDeclarationContext)_localctx).ONSTART = match(ONSTART);
			 int line = (((StartDeclarationContext)_localctx).ONSTART!=null?((StartDeclarationContext)_localctx).ONSTART.getLine():0); 
			setState(261);
			match(LPAREN);
			setState(262);
			match(TRADE);
			setState(263);
			((StartDeclarationContext)_localctx).tradeName = identifier();
			 ((StartDeclarationContext)_localctx).startDecRet =  new OnStartDeclaration(((StartDeclarationContext)_localctx).tradeName.idRet); _localctx.startDecRet.setLine(line); 
			setState(265);
			match(RPAREN);
			setState(268);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				setState(266);
				match(THROW);
				setState(267);
				match(EXCEPTION);
				}
				break;
			}
			setState(283);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
				{
				setState(270);
				match(LBRACE);
				setState(276);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 574484658285715520L) != 0) || ((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & 32767L) != 0)) {
					{
					{
					setState(271);
					((StartDeclarationContext)_localctx).statement = statement();
					 _localctx.startDecRet.addStatement(((StartDeclarationContext)_localctx).statement.statementRet); 
					}
					}
					setState(278);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(279);
				match(RBRACE);
				}
				break;
			case LPAREN:
			case MINUS:
			case NOT:
			case BIT_NOT:
			case INC:
			case DEC:
			case TRY:
			case THROW:
			case IF:
			case FOR:
			case WHILE:
			case BREAK:
			case CONTINUE:
			case RETURN:
			case FLOAT:
			case DOUBLE:
			case STRING:
			case BOOL:
			case VOID:
			case INT:
			case BUY:
			case SELL:
			case TRADE:
			case ORDER:
			case CANDLE:
			case EXCEPTION:
			case REFRESH_RATE:
			case GET_CANDLE:
			case TERMINATE:
			case CONNECT:
			case OBSERVE:
			case PRINT:
			case ID:
			case INT_LITERAL:
			case FLOAT_LITERAL:
			case STRING_LITERAL:
			case BOOL_LITERAL:
				{
				setState(280);
				((StartDeclarationContext)_localctx).statement = statement();
				 _localctx.startDecRet.addStatement(((StartDeclarationContext)_localctx).statement.statementRet); 
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

	@SuppressWarnings("CheckReturnValue")
	public static class AssignStatementContext extends ParserRuleContext {
		public AssignStmt assignStmtRet;
		public IdentifierContext tmpLval;
		public ExpressionContext idx;
		public AssignContext a;
		public ExpressionContext rval;
		public TerminalNode SEMICOLON() { return getToken(UTLParser.SEMICOLON, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public AssignContext assign() {
			return getRuleContext(AssignContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode LBRACK() { return getToken(UTLParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(UTLParser.RBRACK, 0); }
		public AssignStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTLListener ) ((UTLListener)listener).enterAssignStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTLListener ) ((UTLListener)listener).exitAssignStatement(this);
		}
	}

	public final AssignStatementContext assignStatement() throws RecognitionException {
		AssignStatementContext _localctx = new AssignStatementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_assignStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(285);
			((AssignStatementContext)_localctx).tmpLval = identifier();
			 Identifier lval; ArrayIdentifier arrLval; boolean isArr = false;
			setState(292);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACK) {
				{
				setState(287);
				match(LBRACK);
				setState(288);
				((AssignStatementContext)_localctx).idx = expression(0);
				setState(289);
				match(RBRACK);

				//        arrLval = new ArrayIdentifier(((AssignStatementContext)_localctx).tmpLval.idRet.getName(), ((AssignStatementContext)_localctx).idx.expressionRet);
				        isArr = true;
				    
				}
			}

			setState(294);
			((AssignStatementContext)_localctx).a = assign();
			setState(295);
			((AssignStatementContext)_localctx).rval = expression(0);
			setState(296);
			match(SEMICOLON);


			        if (isArr) {
			            arrLval = new ArrayIdentifier(((AssignStatementContext)_localctx).tmpLval.idRet.getName(), ((AssignStatementContext)_localctx).idx.expressionRet);
			            arrLval.setLine(((AssignStatementContext)_localctx).tmpLval.idRet.getLine());
			            ((AssignStatementContext)_localctx).assignStmtRet =  new AssignStmt(arrLval, ((AssignStatementContext)_localctx).rval.expressionRet);
			        }
			        else {
			            lval = new Identifier(((AssignStatementContext)_localctx).tmpLval.idRet.getName());
			            lval.setLine(((AssignStatementContext)_localctx).tmpLval.idRet.getLine());
			            ((AssignStatementContext)_localctx).assignStmtRet =  new AssignStmt(lval, ((AssignStatementContext)_localctx).rval.expressionRet);
			        }
			        _localctx.assignStmtRet.setLine((((AssignStatementContext)_localctx).a!=null?(((AssignStatementContext)_localctx).a.start):null).getLine());
			    
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

	@SuppressWarnings("CheckReturnValue")
	public static class IfStatementContext extends ParserRuleContext {
		public IfElseStmt ifStmtRet;
		public Token IF;
		public ExpressionContext e;
		public StatementContext s;
		public TerminalNode IF() { return getToken(UTLParser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(UTLParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(UTLParser.RPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<TerminalNode> LBRACE() { return getTokens(UTLParser.LBRACE); }
		public TerminalNode LBRACE(int i) {
			return getToken(UTLParser.LBRACE, i);
		}
		public List<TerminalNode> RBRACE() { return getTokens(UTLParser.RBRACE); }
		public TerminalNode RBRACE(int i) {
			return getToken(UTLParser.RBRACE, i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(UTLParser.ELSE, 0); }
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTLListener ) ((UTLListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTLListener ) ((UTLListener)listener).exitIfStatement(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_ifStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(299);
			((IfStatementContext)_localctx).IF = match(IF);
			setState(300);
			match(LPAREN);
			setState(301);
			((IfStatementContext)_localctx).e = expression(0);
			setState(302);
			match(RPAREN);

			        ((IfStatementContext)_localctx).ifStmtRet =  new IfElseStmt(((IfStatementContext)_localctx).e.expressionRet);
			        _localctx.ifStmtRet.setLine((((IfStatementContext)_localctx).IF!=null?((IfStatementContext)_localctx).IF.getLine():0));
			    
			setState(317);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
				{
				setState(304);
				match(LBRACE);
				setState(310);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 574484658285715520L) != 0) || ((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & 32767L) != 0)) {
					{
					{
					setState(305);
					((IfStatementContext)_localctx).s = statement();
					 _localctx.ifStmtRet.addThenStatement(((IfStatementContext)_localctx).s.statementRet); 
					}
					}
					setState(312);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(313);
				match(RBRACE);
				}
				break;
			case LPAREN:
			case MINUS:
			case NOT:
			case BIT_NOT:
			case INC:
			case DEC:
			case TRY:
			case THROW:
			case IF:
			case FOR:
			case WHILE:
			case BREAK:
			case CONTINUE:
			case RETURN:
			case FLOAT:
			case DOUBLE:
			case STRING:
			case BOOL:
			case VOID:
			case INT:
			case BUY:
			case SELL:
			case TRADE:
			case ORDER:
			case CANDLE:
			case EXCEPTION:
			case REFRESH_RATE:
			case GET_CANDLE:
			case TERMINATE:
			case CONNECT:
			case OBSERVE:
			case PRINT:
			case ID:
			case INT_LITERAL:
			case FLOAT_LITERAL:
			case STRING_LITERAL:
			case BOOL_LITERAL:
				{
				setState(314);
				((IfStatementContext)_localctx).s = statement();
				 _localctx.ifStmtRet.addThenStatement(((IfStatementContext)_localctx).s.statementRet); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(335);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				{
				setState(319);
				match(ELSE);
				setState(333);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LBRACE:
					{
					setState(320);
					match(LBRACE);
					setState(326);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 574484658285715520L) != 0) || ((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & 32767L) != 0)) {
						{
						{
						setState(321);
						((IfStatementContext)_localctx).s = statement();
						 _localctx.ifStmtRet.addElseStatement(((IfStatementContext)_localctx).s.statementRet); 
						}
						}
						setState(328);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(329);
					match(RBRACE);
					}
					break;
				case LPAREN:
				case MINUS:
				case NOT:
				case BIT_NOT:
				case INC:
				case DEC:
				case TRY:
				case THROW:
				case IF:
				case FOR:
				case WHILE:
				case BREAK:
				case CONTINUE:
				case RETURN:
				case FLOAT:
				case DOUBLE:
				case STRING:
				case BOOL:
				case VOID:
				case INT:
				case BUY:
				case SELL:
				case TRADE:
				case ORDER:
				case CANDLE:
				case EXCEPTION:
				case REFRESH_RATE:
				case GET_CANDLE:
				case TERMINATE:
				case CONNECT:
				case OBSERVE:
				case PRINT:
				case ID:
				case INT_LITERAL:
				case FLOAT_LITERAL:
				case STRING_LITERAL:
				case BOOL_LITERAL:
					{
					setState(330);
					((IfStatementContext)_localctx).s = statement();
					 _localctx.ifStmtRet.addElseStatement(((IfStatementContext)_localctx).s.statementRet); 
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
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

	@SuppressWarnings("CheckReturnValue")
	public static class WhileStatementContext extends ParserRuleContext {
		public WhileStmt whileStmtRet;
		public Token WHILE;
		public ExpressionContext e;
		public StatementContext s;
		public TerminalNode WHILE() { return getToken(UTLParser.WHILE, 0); }
		public TerminalNode LPAREN() { return getToken(UTLParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(UTLParser.RPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode LBRACE() { return getToken(UTLParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(UTLParser.RBRACE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public WhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTLListener ) ((UTLListener)listener).enterWhileStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTLListener ) ((UTLListener)listener).exitWhileStatement(this);
		}
	}

	public final WhileStatementContext whileStatement() throws RecognitionException {
		WhileStatementContext _localctx = new WhileStatementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_whileStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(337);
			((WhileStatementContext)_localctx).WHILE = match(WHILE);
			setState(338);
			match(LPAREN);
			setState(339);
			((WhileStatementContext)_localctx).e = expression(0);
			setState(340);
			match(RPAREN);

			        ((WhileStatementContext)_localctx).whileStmtRet =  new WhileStmt(((WhileStatementContext)_localctx).e.expressionRet);
			        _localctx.whileStmtRet.setLine((((WhileStatementContext)_localctx).WHILE!=null?((WhileStatementContext)_localctx).WHILE.getLine():0));
			    
			setState(355);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
				{
				setState(342);
				match(LBRACE);
				setState(348);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 574484658285715520L) != 0) || ((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & 32767L) != 0)) {
					{
					{
					setState(343);
					((WhileStatementContext)_localctx).s = statement();
					 _localctx.whileStmtRet.addBody(((WhileStatementContext)_localctx).s.statementRet); 
					}
					}
					setState(350);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(351);
				match(RBRACE);
				}
				break;
			case LPAREN:
			case MINUS:
			case NOT:
			case BIT_NOT:
			case INC:
			case DEC:
			case TRY:
			case THROW:
			case IF:
			case FOR:
			case WHILE:
			case BREAK:
			case CONTINUE:
			case RETURN:
			case FLOAT:
			case DOUBLE:
			case STRING:
			case BOOL:
			case VOID:
			case INT:
			case BUY:
			case SELL:
			case TRADE:
			case ORDER:
			case CANDLE:
			case EXCEPTION:
			case REFRESH_RATE:
			case GET_CANDLE:
			case TERMINATE:
			case CONNECT:
			case OBSERVE:
			case PRINT:
			case ID:
			case INT_LITERAL:
			case FLOAT_LITERAL:
			case STRING_LITERAL:
			case BOOL_LITERAL:
				{
				setState(352);
				((WhileStatementContext)_localctx).s = statement();
				 _localctx.whileStmtRet.addBody(((WhileStatementContext)_localctx).s.statementRet); 
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

	@SuppressWarnings("CheckReturnValue")
	public static class ForStatementContext extends ParserRuleContext {
		public ForStmt forStmtRet;
		public Token FOR;
		public StatementContext i;
		public ExpressionContext c;
		public ExpressionContext u;
		public StatementContext s;
		public TerminalNode FOR() { return getToken(UTLParser.FOR, 0); }
		public TerminalNode LPAREN() { return getToken(UTLParser.LPAREN, 0); }
		public TerminalNode SEMICOLON() { return getToken(UTLParser.SEMICOLON, 0); }
		public TerminalNode RPAREN() { return getToken(UTLParser.RPAREN, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode LBRACE() { return getToken(UTLParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(UTLParser.RBRACE, 0); }
		public ForStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTLListener ) ((UTLListener)listener).enterForStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTLListener ) ((UTLListener)listener).exitForStatement(this);
		}
	}

	public final ForStatementContext forStatement() throws RecognitionException {
		ForStatementContext _localctx = new ForStatementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_forStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((ForStatementContext)_localctx).forStmtRet =  new ForStmt(); 
			setState(358);
			((ForStatementContext)_localctx).FOR = match(FOR);
			setState(359);
			match(LPAREN);
			setState(360);
			((ForStatementContext)_localctx).i = statement();
			setState(361);
			((ForStatementContext)_localctx).c = expression(0);
			setState(362);
			match(SEMICOLON);
			setState(366);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 432345567482880064L) != 0) || ((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & 32767L) != 0)) {
				{
				setState(363);
				((ForStatementContext)_localctx).u = expression(0);
				 _localctx.forStmtRet.addUpdate(((ForStatementContext)_localctx).u.expressionRet); 
				}
			}

			setState(368);
			match(RPAREN);

			        _localctx.forStmtRet.addInit(((ForStatementContext)_localctx).i.statementRet);
			        _localctx.forStmtRet.setCondition(((ForStatementContext)_localctx).c.expressionRet);
			        _localctx.forStmtRet.setLine((((ForStatementContext)_localctx).FOR!=null?((ForStatementContext)_localctx).FOR.getLine():0));
			    
			setState(383);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
				{
				setState(370);
				match(LBRACE);
				setState(376);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 574484658285715520L) != 0) || ((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & 32767L) != 0)) {
					{
					{
					setState(371);
					((ForStatementContext)_localctx).s = statement();
					 _localctx.forStmtRet.addBody(((ForStatementContext)_localctx).s.statementRet); 
					}
					}
					setState(378);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(379);
				match(RBRACE);
				}
				break;
			case LPAREN:
			case MINUS:
			case NOT:
			case BIT_NOT:
			case INC:
			case DEC:
			case TRY:
			case THROW:
			case IF:
			case FOR:
			case WHILE:
			case BREAK:
			case CONTINUE:
			case RETURN:
			case FLOAT:
			case DOUBLE:
			case STRING:
			case BOOL:
			case VOID:
			case INT:
			case BUY:
			case SELL:
			case TRADE:
			case ORDER:
			case CANDLE:
			case EXCEPTION:
			case REFRESH_RATE:
			case GET_CANDLE:
			case TERMINATE:
			case CONNECT:
			case OBSERVE:
			case PRINT:
			case ID:
			case INT_LITERAL:
			case FLOAT_LITERAL:
			case STRING_LITERAL:
			case BOOL_LITERAL:
				{
				setState(380);
				((ForStatementContext)_localctx).s = statement();
				 _localctx.forStmtRet.addBody(((ForStatementContext)_localctx).s.statementRet); 
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

	@SuppressWarnings("CheckReturnValue")
	public static class TryCatchStatementContext extends ParserRuleContext {
		public TryCatchStmt tryCatchStmtRet;
		public Token TRY;
		public StatementContext s;
		public TerminalNode TRY() { return getToken(UTLParser.TRY, 0); }
		public List<TerminalNode> LBRACE() { return getTokens(UTLParser.LBRACE); }
		public TerminalNode LBRACE(int i) {
			return getToken(UTLParser.LBRACE, i);
		}
		public List<TerminalNode> RBRACE() { return getTokens(UTLParser.RBRACE); }
		public TerminalNode RBRACE(int i) {
			return getToken(UTLParser.RBRACE, i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode CATCH() { return getToken(UTLParser.CATCH, 0); }
		public TerminalNode EXCEPTION() { return getToken(UTLParser.EXCEPTION, 0); }
		public TerminalNode ID() { return getToken(UTLParser.ID, 0); }
		public TryCatchStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tryCatchStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTLListener ) ((UTLListener)listener).enterTryCatchStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTLListener ) ((UTLListener)listener).exitTryCatchStatement(this);
		}
	}

	public final TryCatchStatementContext tryCatchStatement() throws RecognitionException {
		TryCatchStatementContext _localctx = new TryCatchStatementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_tryCatchStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 ((TryCatchStatementContext)_localctx).tryCatchStmtRet =  new TryCatchStmt(); 
			setState(386);
			((TryCatchStatementContext)_localctx).TRY = match(TRY);
			 _localctx.tryCatchStmtRet.setLine((((TryCatchStatementContext)_localctx).TRY!=null?((TryCatchStatementContext)_localctx).TRY.getLine():0)); 
			setState(401);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
				{
				setState(388);
				match(LBRACE);
				setState(394);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 574484658285715520L) != 0) || ((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & 32767L) != 0)) {
					{
					{
					setState(389);
					((TryCatchStatementContext)_localctx).s = statement();
					 _localctx.tryCatchStmtRet.addThenStatement(((TryCatchStatementContext)_localctx).s.statementRet); 
					}
					}
					setState(396);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(397);
				match(RBRACE);
				}
				break;
			case LPAREN:
			case MINUS:
			case NOT:
			case BIT_NOT:
			case INC:
			case DEC:
			case TRY:
			case THROW:
			case IF:
			case FOR:
			case WHILE:
			case BREAK:
			case CONTINUE:
			case RETURN:
			case FLOAT:
			case DOUBLE:
			case STRING:
			case BOOL:
			case VOID:
			case INT:
			case BUY:
			case SELL:
			case TRADE:
			case ORDER:
			case CANDLE:
			case EXCEPTION:
			case REFRESH_RATE:
			case GET_CANDLE:
			case TERMINATE:
			case CONNECT:
			case OBSERVE:
			case PRINT:
			case ID:
			case INT_LITERAL:
			case FLOAT_LITERAL:
			case STRING_LITERAL:
			case BOOL_LITERAL:
				{
				setState(398);
				((TryCatchStatementContext)_localctx).s = statement();
				 _localctx.tryCatchStmtRet.addThenStatement(((TryCatchStatementContext)_localctx).s.statementRet); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(421);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				{
				setState(403);
				match(CATCH);
				setState(404);
				match(EXCEPTION);
				setState(405);
				match(ID);
				setState(419);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LBRACE:
					{
					setState(406);
					match(LBRACE);
					setState(412);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 574484658285715520L) != 0) || ((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & 32767L) != 0)) {
						{
						{
						setState(407);
						((TryCatchStatementContext)_localctx).s = statement();
						 _localctx.tryCatchStmtRet.addElseStatement(((TryCatchStatementContext)_localctx).s.statementRet); 
						}
						}
						setState(414);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(415);
					match(RBRACE);
					}
					break;
				case LPAREN:
				case MINUS:
				case NOT:
				case BIT_NOT:
				case INC:
				case DEC:
				case TRY:
				case THROW:
				case IF:
				case FOR:
				case WHILE:
				case BREAK:
				case CONTINUE:
				case RETURN:
				case FLOAT:
				case DOUBLE:
				case STRING:
				case BOOL:
				case VOID:
				case INT:
				case BUY:
				case SELL:
				case TRADE:
				case ORDER:
				case CANDLE:
				case EXCEPTION:
				case REFRESH_RATE:
				case GET_CANDLE:
				case TERMINATE:
				case CONNECT:
				case OBSERVE:
				case PRINT:
				case ID:
				case INT_LITERAL:
				case FLOAT_LITERAL:
				case STRING_LITERAL:
				case BOOL_LITERAL:
					{
					setState(416);
					((TryCatchStatementContext)_localctx).s = statement();
					 _localctx.tryCatchStmtRet.addElseStatement(((TryCatchStatementContext)_localctx).s.statementRet); 
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
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

	@SuppressWarnings("CheckReturnValue")
	public static class ContinueBreakStatementContext extends ParserRuleContext {
		public ContinueBreakStmt continueBreakStmtRet;
		public Token txt;
		public TerminalNode SEMICOLON() { return getToken(UTLParser.SEMICOLON, 0); }
		public TerminalNode BREAK() { return getToken(UTLParser.BREAK, 0); }
		public TerminalNode CONTINUE() { return getToken(UTLParser.CONTINUE, 0); }
		public ContinueBreakStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_continueBreakStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTLListener ) ((UTLListener)listener).enterContinueBreakStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTLListener ) ((UTLListener)listener).exitContinueBreakStatement(this);
		}
	}

	public final ContinueBreakStatementContext continueBreakStatement() throws RecognitionException {
		ContinueBreakStatementContext _localctx = new ContinueBreakStatementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_continueBreakStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(423);
			((ContinueBreakStatementContext)_localctx).txt = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==BREAK || _la==CONTINUE) ) {
				((ContinueBreakStatementContext)_localctx).txt = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}

			        ((ContinueBreakStatementContext)_localctx).continueBreakStmtRet =  new ContinueBreakStmt((((ContinueBreakStatementContext)_localctx).txt!=null?((ContinueBreakStatementContext)_localctx).txt.getText():null));
			        _localctx.continueBreakStmtRet.setLine((((ContinueBreakStatementContext)_localctx).txt!=null?((ContinueBreakStatementContext)_localctx).txt.getLine():0));
			    
			setState(425);
			match(SEMICOLON);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ReturnStatementContext extends ParserRuleContext {
		public ReturnStmt returnStmtRet;
		public Token RETURN;
		public ExpressionContext e;
		public TerminalNode RETURN() { return getToken(UTLParser.RETURN, 0); }
		public TerminalNode SEMICOLON() { return getToken(UTLParser.SEMICOLON, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTLListener ) ((UTLListener)listener).enterReturnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTLListener ) ((UTLListener)listener).exitReturnStatement(this);
		}
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_returnStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(427);
			((ReturnStatementContext)_localctx).RETURN = match(RETURN);
			setState(428);
			((ReturnStatementContext)_localctx).e = expression(0);

			        ((ReturnStatementContext)_localctx).returnStmtRet =  new ReturnStmt(((ReturnStatementContext)_localctx).e.expressionRet);
			        _localctx.returnStmtRet.setLine((((ReturnStatementContext)_localctx).RETURN!=null?((ReturnStatementContext)_localctx).RETURN.getLine():0));
			    
			setState(430);
			match(SEMICOLON);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ThrowStatementContext extends ParserRuleContext {
		public ThrowStmt throwStmtRet;
		public Token THROW;
		public ExpressionContext e;
		public TerminalNode THROW() { return getToken(UTLParser.THROW, 0); }
		public TerminalNode SEMICOLON() { return getToken(UTLParser.SEMICOLON, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ThrowStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_throwStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTLListener ) ((UTLListener)listener).enterThrowStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTLListener ) ((UTLListener)listener).exitThrowStatement(this);
		}
	}

	public final ThrowStatementContext throwStatement() throws RecognitionException {
		ThrowStatementContext _localctx = new ThrowStatementContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_throwStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(432);
			((ThrowStatementContext)_localctx).THROW = match(THROW);
			setState(433);
			((ThrowStatementContext)_localctx).e = expression(0);

			        ((ThrowStatementContext)_localctx).throwStmtRet =  new ThrowStmt(((ThrowStatementContext)_localctx).e.expressionRet);
			        _localctx.throwStmtRet.setLine((((ThrowStatementContext)_localctx).THROW!=null?((ThrowStatementContext)_localctx).THROW.getLine():0));
			    
			setState(435);
			match(SEMICOLON);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionCallContext extends ParserRuleContext {
		public FunctionCall funcCallRet;
		public SpecialFunctionContext sf;
		public ComplexTypeContext ct;
		public IdentifierContext id;
		public Token LPAREN;
		public ExpressionContext e;
		public TerminalNode LPAREN() { return getToken(UTLParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(UTLParser.RPAREN, 0); }
		public SpecialFunctionContext specialFunction() {
			return getRuleContext(SpecialFunctionContext.class,0);
		}
		public ComplexTypeContext complexType() {
			return getRuleContext(ComplexTypeContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(UTLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(UTLParser.COMMA, i);
		}
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTLListener ) ((UTLListener)listener).enterFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTLListener ) ((UTLListener)listener).exitFunctionCall(this);
		}
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_functionCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 Identifier funcName; 
			setState(447);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case REFRESH_RATE:
			case GET_CANDLE:
			case TERMINATE:
			case CONNECT:
			case OBSERVE:
			case PRINT:
				{
				setState(438);
				((FunctionCallContext)_localctx).sf = specialFunction();
				 funcName = new Identifier((((FunctionCallContext)_localctx).sf!=null?_input.getText(((FunctionCallContext)_localctx).sf.start,((FunctionCallContext)_localctx).sf.stop):null)); funcName.setLine((((FunctionCallContext)_localctx).sf!=null?(((FunctionCallContext)_localctx).sf.start):null).getLine()); 
				}
				break;
			case TRADE:
			case ORDER:
			case CANDLE:
			case EXCEPTION:
				{
				setState(441);
				((FunctionCallContext)_localctx).ct = complexType();
				 funcName = new Identifier((((FunctionCallContext)_localctx).ct!=null?_input.getText(((FunctionCallContext)_localctx).ct.start,((FunctionCallContext)_localctx).ct.stop):null)); funcName.setLine((((FunctionCallContext)_localctx).ct!=null?(((FunctionCallContext)_localctx).ct.start):null).getLine()); 
				}
				break;
			case ID:
				{
				setState(444);
				((FunctionCallContext)_localctx).id = identifier();
				 funcName = ((FunctionCallContext)_localctx).id.idRet; funcName.setLine(((FunctionCallContext)_localctx).id.idRet.getLine()); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			 ((FunctionCallContext)_localctx).funcCallRet =  new FunctionCall(funcName); 
			setState(450);
			((FunctionCallContext)_localctx).LPAREN = match(LPAREN);
			 _localctx.funcCallRet.setLine((((FunctionCallContext)_localctx).LPAREN!=null?((FunctionCallContext)_localctx).LPAREN.getLine():0)); 
			setState(463);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 432345567482880064L) != 0) || ((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & 32767L) != 0)) {
				{
				setState(452);
				((FunctionCallContext)_localctx).e = expression(0);
				 _localctx.funcCallRet.addArg(((FunctionCallContext)_localctx).e.expressionRet); 
				setState(460);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(454);
					match(COMMA);
					setState(455);
					((FunctionCallContext)_localctx).e = expression(0);
					 _localctx.funcCallRet.addArg(((FunctionCallContext)_localctx).e.expressionRet); 
					}
					}
					setState(462);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(465);
			match(RPAREN);
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

	@SuppressWarnings("CheckReturnValue")
	public static class MethodCallContext extends ParserRuleContext {
		public MethodCall methodCallRet;
		public IdentifierContext id;
		public ExpressionContext idx;
		public SpecialMethodContext sm;
		public ExpressionContext e;
		public TerminalNode DOT() { return getToken(UTLParser.DOT, 0); }
		public TerminalNode LPAREN() { return getToken(UTLParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(UTLParser.RPAREN, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public SpecialMethodContext specialMethod() {
			return getRuleContext(SpecialMethodContext.class,0);
		}
		public TerminalNode LBRACK() { return getToken(UTLParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(UTLParser.RBRACK, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(UTLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(UTLParser.COMMA, i);
		}
		public MethodCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTLListener ) ((UTLListener)listener).enterMethodCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTLListener ) ((UTLListener)listener).exitMethodCall(this);
		}
	}

	public final MethodCallContext methodCall() throws RecognitionException {
		MethodCallContext _localctx = new MethodCallContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_methodCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 Identifier ins; ArrayIdentifier arrIns; boolean isArr = false; 
			setState(468);
			((MethodCallContext)_localctx).id = identifier();
			setState(474);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACK) {
				{
				setState(469);
				match(LBRACK);
				setState(470);
				((MethodCallContext)_localctx).idx = expression(0);
				setState(471);
				match(RBRACK);

				        isArr = true;
				    
				}
			}

			setState(476);
			match(DOT);
			setState(477);
			((MethodCallContext)_localctx).sm = specialMethod();

			        Identifier funcName = new Identifier((((MethodCallContext)_localctx).sm!=null?_input.getText(((MethodCallContext)_localctx).sm.start,((MethodCallContext)_localctx).sm.stop):null));
			        funcName.setLine((((MethodCallContext)_localctx).sm!=null?(((MethodCallContext)_localctx).sm.start):null).getLine());
			        if (isArr) {
			            arrIns = new ArrayIdentifier(((MethodCallContext)_localctx).id.idRet.getName(), ((MethodCallContext)_localctx).idx.expressionRet);
			            arrIns.setLine(((MethodCallContext)_localctx).id.idRet.getLine());
			            ((MethodCallContext)_localctx).methodCallRet =  new MethodCall(arrIns, funcName);
			        }
			        else {
			            ins = new Identifier(((MethodCallContext)_localctx).id.idRet.getName());
			            ins.setLine(((MethodCallContext)_localctx).id.idRet.getLine());
			            ((MethodCallContext)_localctx).methodCallRet =  new MethodCall(ins, funcName);

			        }
			        _localctx.methodCallRet.setLine(((MethodCallContext)_localctx).id.idRet.getLine());

			    
			setState(479);
			match(LPAREN);
			setState(491);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 432345567482880064L) != 0) || ((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & 32767L) != 0)) {
				{
				setState(480);
				((MethodCallContext)_localctx).e = expression(0);
				 _localctx.methodCallRet.addArg(((MethodCallContext)_localctx).e.expressionRet); 
				setState(488);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(482);
					match(COMMA);
					setState(483);
					((MethodCallContext)_localctx).e = expression(0);
					 _localctx.methodCallRet.addArg(((MethodCallContext)_localctx).e.expressionRet); 
					}
					}
					setState(490);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(493);
			match(RPAREN);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public Expression expressionRet;
		public ExpressionContext e;
		public ExpressionContext lval;
		public ValueContext val;
		public Token opr;
		public IdentifierContext arrId;
		public ExpressionContext idx;
		public IdentifierContext id;
		public Token LPAREN;
		public FunctionCallContext fc;
		public MethodCallContext mc;
		public ExpressionContext rval;
		public SpecialVariableContext sv;
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode NOT() { return getToken(UTLParser.NOT, 0); }
		public TerminalNode MINUS() { return getToken(UTLParser.MINUS, 0); }
		public TerminalNode BIT_NOT() { return getToken(UTLParser.BIT_NOT, 0); }
		public TerminalNode INC() { return getToken(UTLParser.INC, 0); }
		public TerminalNode DEC() { return getToken(UTLParser.DEC, 0); }
		public TerminalNode LBRACK() { return getToken(UTLParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(UTLParser.RBRACK, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(UTLParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(UTLParser.RPAREN, 0); }
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public MethodCallContext methodCall() {
			return getRuleContext(MethodCallContext.class,0);
		}
		public TerminalNode MULT() { return getToken(UTLParser.MULT, 0); }
		public TerminalNode DIV() { return getToken(UTLParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(UTLParser.MOD, 0); }
		public TerminalNode PLUS() { return getToken(UTLParser.PLUS, 0); }
		public TerminalNode L_SHIFT() { return getToken(UTLParser.L_SHIFT, 0); }
		public TerminalNode R_SHIFT() { return getToken(UTLParser.R_SHIFT, 0); }
		public TerminalNode LT() { return getToken(UTLParser.LT, 0); }
		public TerminalNode GT() { return getToken(UTLParser.GT, 0); }
		public TerminalNode EQ() { return getToken(UTLParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(UTLParser.NEQ, 0); }
		public TerminalNode BIT_AND() { return getToken(UTLParser.BIT_AND, 0); }
		public TerminalNode BIT_OR() { return getToken(UTLParser.BIT_OR, 0); }
		public TerminalNode BIT_XOR() { return getToken(UTLParser.BIT_XOR, 0); }
		public TerminalNode AND() { return getToken(UTLParser.AND, 0); }
		public List<TerminalNode> OR() { return getTokens(UTLParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(UTLParser.OR, i);
		}
		public TerminalNode DOT() { return getToken(UTLParser.DOT, 0); }
		public SpecialVariableContext specialVariable() {
			return getRuleContext(SpecialVariableContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTLListener ) ((UTLListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTLListener ) ((UTLListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 38;
		enterRecursionRule(_localctx, 38, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(535);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
			case 1:
				{
				setState(496);
				((ExpressionContext)_localctx).val = value();

				                    ((ExpressionContext)_localctx).expressionRet =  ((ExpressionContext)_localctx).val.valueRet;
				                    _localctx.expressionRet.setLine(((ExpressionContext)_localctx).val.valueRet.getLine());
				                
				}
				break;
			case 2:
				{
				 UnaryOperator uop; 
				setState(510);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case NOT:
					{
					setState(500);
					((ExpressionContext)_localctx).opr = match(NOT);
					 uop = UnaryOperator.NOT; 
					}
					break;
				case MINUS:
					{
					setState(502);
					((ExpressionContext)_localctx).opr = match(MINUS);
					 uop = UnaryOperator.MINUS; 
					}
					break;
				case BIT_NOT:
					{
					setState(504);
					((ExpressionContext)_localctx).opr = match(BIT_NOT);
					 uop = UnaryOperator.BIT_NOT; 
					}
					break;
				case INC:
					{
					setState(506);
					((ExpressionContext)_localctx).opr = match(INC);
					 uop = UnaryOperator.INC; 
					}
					break;
				case DEC:
					{
					setState(508);
					((ExpressionContext)_localctx).opr = match(DEC);
					 uop = UnaryOperator.DEC; 
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(512);
				((ExpressionContext)_localctx).e = expression(14);

				                    UnaryExpression ue = new UnaryExpression(uop, ((ExpressionContext)_localctx).e.expressionRet);
				                    ((ExpressionContext)_localctx).expressionRet =  ue;
				                    _localctx.expressionRet.setLine(((ExpressionContext)_localctx).opr.getLine());
				                
				}
				break;
			case 3:
				{
				setState(515);
				((ExpressionContext)_localctx).arrId = identifier();
				setState(516);
				match(LBRACK);
				setState(517);
				((ExpressionContext)_localctx).idx = expression(0);
				setState(518);
				match(RBRACK);

				                    ArrayIdentifier ai = new ArrayIdentifier(((ExpressionContext)_localctx).arrId.idRet.getName(), ((ExpressionContext)_localctx).idx.expressionRet);
				                    ai.setLine(((ExpressionContext)_localctx).arrId.idRet.getLine());
				                    ((ExpressionContext)_localctx).expressionRet =  ai;
				                    _localctx.expressionRet.setLine(ai.getLine());
				               
				}
				break;
			case 4:
				{
				setState(521);
				((ExpressionContext)_localctx).id = identifier();

				                    ((ExpressionContext)_localctx).expressionRet =  ((ExpressionContext)_localctx).id.idRet;
				                    _localctx.expressionRet.setLine(((ExpressionContext)_localctx).id.idRet.getLine());
				               
				}
				break;
			case 5:
				{
				setState(524);
				((ExpressionContext)_localctx).LPAREN = match(LPAREN);
				setState(525);
				((ExpressionContext)_localctx).e = expression(0);
				setState(526);
				match(RPAREN);

				                    ((ExpressionContext)_localctx).expressionRet =  ((ExpressionContext)_localctx).e.expressionRet;
				                    _localctx.expressionRet.setLine((((ExpressionContext)_localctx).LPAREN!=null?((ExpressionContext)_localctx).LPAREN.getLine():0));
				               
				}
				break;
			case 6:
				{
				setState(529);
				((ExpressionContext)_localctx).fc = functionCall();

				                    ((ExpressionContext)_localctx).expressionRet =  ((ExpressionContext)_localctx).fc.funcCallRet;
				                    _localctx.expressionRet.setLine(((ExpressionContext)_localctx).fc.funcCallRet.getLine());
				               
				}
				break;
			case 7:
				{
				setState(532);
				((ExpressionContext)_localctx).mc = methodCall();

				                    ((ExpressionContext)_localctx).expressionRet =  ((ExpressionContext)_localctx).mc.methodCallRet;
				                    _localctx.expressionRet.setLine(((ExpressionContext)_localctx).mc.methodCallRet.getLine());
				               
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(642);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,54,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(640);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,53,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.lval = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(537);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						 BinaryOperator bop; 
						setState(545);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case MULT:
							{
							setState(539);
							((ExpressionContext)_localctx).opr = match(MULT);
							 bop = BinaryOperator.MULT; 
							}
							break;
						case DIV:
							{
							setState(541);
							((ExpressionContext)_localctx).opr = match(DIV);
							 bop = BinaryOperator.DIV; 
							}
							break;
						case MOD:
							{
							setState(543);
							((ExpressionContext)_localctx).opr = match(MOD);
							 bop = BinaryOperator.MOD; 
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(547);
						((ExpressionContext)_localctx).rval = expression(14);

						                              BinaryExpression be = new BinaryExpression(((ExpressionContext)_localctx).lval.expressionRet, ((ExpressionContext)_localctx).rval.expressionRet, bop);
						                              ((ExpressionContext)_localctx).expressionRet =  be;
						                              _localctx.expressionRet.setLine(((ExpressionContext)_localctx).opr.getLine());
						                         
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.lval = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(550);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						 BinaryOperator bop; 
						setState(556);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case PLUS:
							{
							setState(552);
							((ExpressionContext)_localctx).opr = match(PLUS);
							 bop = BinaryOperator.PLUS; 
							}
							break;
						case MINUS:
							{
							setState(554);
							((ExpressionContext)_localctx).opr = match(MINUS);
							 bop = BinaryOperator.MINUS; 
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(558);
						((ExpressionContext)_localctx).rval = expression(13);

						                              BinaryExpression be = new BinaryExpression(((ExpressionContext)_localctx).lval.expressionRet, ((ExpressionContext)_localctx).rval.expressionRet, bop);
						                              ((ExpressionContext)_localctx).expressionRet =  be;
						                              _localctx.expressionRet.setLine(((ExpressionContext)_localctx).opr.getLine());
						                         
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.lval = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(561);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						 BinaryOperator bop; 
						setState(567);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case L_SHIFT:
							{
							setState(563);
							((ExpressionContext)_localctx).opr = match(L_SHIFT);
							 bop = BinaryOperator.L_SHIFT; 
							}
							break;
						case R_SHIFT:
							{
							setState(565);
							((ExpressionContext)_localctx).opr = match(R_SHIFT);
							 bop = BinaryOperator.R_SHIFT; 
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(569);
						((ExpressionContext)_localctx).rval = expression(12);

						                              BinaryExpression be = new BinaryExpression(((ExpressionContext)_localctx).lval.expressionRet, ((ExpressionContext)_localctx).rval.expressionRet, bop);
						                              ((ExpressionContext)_localctx).expressionRet =  be;
						                              _localctx.expressionRet.setLine(((ExpressionContext)_localctx).opr.getLine());
						                         
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.lval = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(572);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						 BinaryOperator bop; 
						setState(578);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case LT:
							{
							setState(574);
							((ExpressionContext)_localctx).opr = match(LT);
							 bop = BinaryOperator.LT; 
							}
							break;
						case GT:
							{
							setState(576);
							((ExpressionContext)_localctx).opr = match(GT);
							 bop = BinaryOperator.GT; 
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(580);
						((ExpressionContext)_localctx).rval = expression(11);

						                              BinaryExpression be = new BinaryExpression(((ExpressionContext)_localctx).lval.expressionRet, ((ExpressionContext)_localctx).rval.expressionRet, bop);
						                              ((ExpressionContext)_localctx).expressionRet =  be;
						                              _localctx.expressionRet.setLine(((ExpressionContext)_localctx).opr.getLine());
						                         
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.lval = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(583);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						 BinaryOperator bop; 
						setState(589);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case EQ:
							{
							setState(585);
							((ExpressionContext)_localctx).opr = match(EQ);
							 bop = BinaryOperator.EQ; 
							}
							break;
						case NEQ:
							{
							setState(587);
							((ExpressionContext)_localctx).opr = match(NEQ);
							 bop = BinaryOperator.NEQ; 
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(591);
						((ExpressionContext)_localctx).rval = expression(10);

						                              BinaryExpression be = new BinaryExpression(((ExpressionContext)_localctx).lval.expressionRet, ((ExpressionContext)_localctx).rval.expressionRet, bop);
						                              ((ExpressionContext)_localctx).expressionRet =  be;
						                              _localctx.expressionRet.setLine(((ExpressionContext)_localctx).opr.getLine());
						                         
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.lval = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(594);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						 BinaryOperator bop; 
						setState(602);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case BIT_AND:
							{
							setState(596);
							((ExpressionContext)_localctx).opr = match(BIT_AND);
							 bop = BinaryOperator.BIT_AND; 
							}
							break;
						case BIT_OR:
							{
							setState(598);
							((ExpressionContext)_localctx).opr = match(BIT_OR);
							 bop = BinaryOperator.BIT_OR; 
							}
							break;
						case BIT_XOR:
							{
							setState(600);
							((ExpressionContext)_localctx).opr = match(BIT_XOR);
							 bop = BinaryOperator.BIT_XOR; 
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(604);
						((ExpressionContext)_localctx).rval = expression(9);

						                              BinaryExpression be = new BinaryExpression(((ExpressionContext)_localctx).lval.expressionRet, ((ExpressionContext)_localctx).rval.expressionRet, bop);
						                              ((ExpressionContext)_localctx).expressionRet =  be;
						                              _localctx.expressionRet.setLine(((ExpressionContext)_localctx).opr.getLine());
						                         
						}
						break;
					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.lval = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(607);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						 BinaryOperator bop; 
						{
						setState(609);
						((ExpressionContext)_localctx).opr = match(AND);
						 bop = BinaryOperator.AND; 
						}
						setState(612);
						((ExpressionContext)_localctx).rval = expression(8);

						                              BinaryExpression be = new BinaryExpression(((ExpressionContext)_localctx).lval.expressionRet, ((ExpressionContext)_localctx).rval.expressionRet, bop);
						                              ((ExpressionContext)_localctx).expressionRet =  be;
						                              _localctx.expressionRet.setLine(((ExpressionContext)_localctx).opr.getLine());
						                         
						}
						break;
					case 8:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(615);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(616);
						match(OR);
						setState(617);
						expression(0);
						setState(618);
						((ExpressionContext)_localctx).lval = expression(0);
						 BinaryOperator bop = BinaryOperator.OR; 
						{
						setState(620);
						((ExpressionContext)_localctx).opr = match(OR);
						 bop = BinaryOperator.OR; 
						}
						setState(623);
						((ExpressionContext)_localctx).rval = expression(7);

						                              BinaryExpression be = new BinaryExpression(((ExpressionContext)_localctx).lval.expressionRet, ((ExpressionContext)_localctx).rval.expressionRet, bop);
						                              ((ExpressionContext)_localctx).expressionRet =  be;
						                              _localctx.expressionRet.setLine(((ExpressionContext)_localctx).opr.getLine());
						                         
						}
						break;
					case 9:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(626);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(627);
						match(DOT);
						setState(628);
						((ExpressionContext)_localctx).sv = specialVariable();

						                              Identifier varName = new Identifier((((ExpressionContext)_localctx).sv!=null?_input.getText(((ExpressionContext)_localctx).sv.start,((ExpressionContext)_localctx).sv.stop):null));
						                              varName.setLine((((ExpressionContext)_localctx).sv!=null?(((ExpressionContext)_localctx).sv.start):null).getLine());
						                              VarAccess varAccess = new VarAccess(((ExpressionContext)_localctx).e.expressionRet, varName);
						                              varAccess.setLine(((ExpressionContext)_localctx).e.expressionRet.getLine());
						                              ((ExpressionContext)_localctx).expressionRet =  varAccess;
						                          
						}
						break;
					case 10:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(631);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						 UnaryOperator uop; 
						setState(637);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case INC:
							{
							setState(633);
							((ExpressionContext)_localctx).opr = match(INC);
							 uop = UnaryOperator.INC; 
							}
							break;
						case DEC:
							{
							setState(635);
							((ExpressionContext)_localctx).opr = match(DEC);
							 uop = UnaryOperator.DEC; 
							}
							break;
						default:
							throw new NoViableAltException(this);
						}

						                              UnaryExpression ue = new UnaryExpression(uop, ((ExpressionContext)_localctx).e.expressionRet);
						                              ((ExpressionContext)_localctx).expressionRet =  ue;
						                              _localctx.expressionRet.setLine(((ExpressionContext)_localctx).opr.getLine());
						                          
						}
						break;
					}
					} 
				}
				setState(644);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,54,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ValueContext extends ParserRuleContext {
		public Value valueRet;
		public Token i;
		public Token f;
		public Token b;
		public Token s;
		public Token se;
		public Token bu;
		public TerminalNode INT_LITERAL() { return getToken(UTLParser.INT_LITERAL, 0); }
		public TerminalNode FLOAT_LITERAL() { return getToken(UTLParser.FLOAT_LITERAL, 0); }
		public TerminalNode BOOL_LITERAL() { return getToken(UTLParser.BOOL_LITERAL, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(UTLParser.STRING_LITERAL, 0); }
		public TerminalNode SELL() { return getToken(UTLParser.SELL, 0); }
		public TerminalNode BUY() { return getToken(UTLParser.BUY, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTLListener ) ((UTLListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTLListener ) ((UTLListener)listener).exitValue(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_value);
		try {
			setState(657);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT_LITERAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(645);
				((ValueContext)_localctx).i = match(INT_LITERAL);
				 ((ValueContext)_localctx).valueRet =  new IntValue((((ValueContext)_localctx).i!=null?Integer.valueOf(((ValueContext)_localctx).i.getText()):0)); _localctx.valueRet.setLine(((ValueContext)_localctx).i.getLine()); 
				}
				break;
			case FLOAT_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(647);
				((ValueContext)_localctx).f = match(FLOAT_LITERAL);
				 ((ValueContext)_localctx).valueRet =  new FloatValue(Float.parseFloat((((ValueContext)_localctx).f!=null?((ValueContext)_localctx).f.getText():null))); _localctx.valueRet.setLine(((ValueContext)_localctx).f.getLine()); 
				}
				break;
			case BOOL_LITERAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(649);
				((ValueContext)_localctx).b = match(BOOL_LITERAL);
				 ((ValueContext)_localctx).valueRet =  new BoolValue(Boolean.valueOf((((ValueContext)_localctx).b!=null?((ValueContext)_localctx).b.getText():null))); _localctx.valueRet.setLine(((ValueContext)_localctx).b.getLine()); 
				}
				break;
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 4);
				{
				setState(651);
				((ValueContext)_localctx).s = match(STRING_LITERAL);
				 ((ValueContext)_localctx).valueRet =  new StringValue((((ValueContext)_localctx).s!=null?((ValueContext)_localctx).s.getText():null)); _localctx.valueRet.setLine(((ValueContext)_localctx).s.getLine()); 
				}
				break;
			case SELL:
				enterOuterAlt(_localctx, 5);
				{
				setState(653);
				((ValueContext)_localctx).se = match(SELL);
				 ((ValueContext)_localctx).valueRet =  new TradeValue("SELL"); _localctx.valueRet.setLine(((ValueContext)_localctx).se.getLine()); 
				}
				break;
			case BUY:
				enterOuterAlt(_localctx, 6);
				{
				setState(655);
				((ValueContext)_localctx).bu = match(BUY);
				 ((ValueContext)_localctx).valueRet =  new TradeValue("BUY"); _localctx.valueRet.setLine(((ValueContext)_localctx).bu.getLine()); 
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

	@SuppressWarnings("CheckReturnValue")
	public static class PrimitiveTypeContext extends ParserRuleContext {
		public Type primitiveTypeRet;
		public TerminalNode FLOAT() { return getToken(UTLParser.FLOAT, 0); }
		public TerminalNode DOUBLE() { return getToken(UTLParser.DOUBLE, 0); }
		public TerminalNode INT() { return getToken(UTLParser.INT, 0); }
		public TerminalNode BOOL() { return getToken(UTLParser.BOOL, 0); }
		public TerminalNode STRING() { return getToken(UTLParser.STRING, 0); }
		public TerminalNode VOID() { return getToken(UTLParser.VOID, 0); }
		public PrimitiveTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitiveType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTLListener ) ((UTLListener)listener).enterPrimitiveType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTLListener ) ((UTLListener)listener).exitPrimitiveType(this);
		}
	}

	public final PrimitiveTypeContext primitiveType() throws RecognitionException {
		PrimitiveTypeContext _localctx = new PrimitiveTypeContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_primitiveType);
		try {
			setState(671);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FLOAT:
				enterOuterAlt(_localctx, 1);
				{
				setState(659);
				match(FLOAT);
				 ((PrimitiveTypeContext)_localctx).primitiveTypeRet =  new FloatType(); 
				}
				break;
			case DOUBLE:
				enterOuterAlt(_localctx, 2);
				{
				setState(661);
				match(DOUBLE);
				 ((PrimitiveTypeContext)_localctx).primitiveTypeRet =  new DoubleType(); 
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 3);
				{
				setState(663);
				match(INT);
				 ((PrimitiveTypeContext)_localctx).primitiveTypeRet =  new IntType(); 
				}
				break;
			case BOOL:
				enterOuterAlt(_localctx, 4);
				{
				setState(665);
				match(BOOL);
				 ((PrimitiveTypeContext)_localctx).primitiveTypeRet =  new BoolType(); 
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 5);
				{
				setState(667);
				match(STRING);
				 ((PrimitiveTypeContext)_localctx).primitiveTypeRet =  new StringType(); 
				}
				break;
			case VOID:
				enterOuterAlt(_localctx, 6);
				{
				setState(669);
				match(VOID);
				 ((PrimitiveTypeContext)_localctx).primitiveTypeRet =  new VoidType(); 
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

	@SuppressWarnings("CheckReturnValue")
	public static class ComplexTypeContext extends ParserRuleContext {
		public Type complexTypeRet;
		public TerminalNode ORDER() { return getToken(UTLParser.ORDER, 0); }
		public TerminalNode TRADE() { return getToken(UTLParser.TRADE, 0); }
		public TerminalNode CANDLE() { return getToken(UTLParser.CANDLE, 0); }
		public TerminalNode EXCEPTION() { return getToken(UTLParser.EXCEPTION, 0); }
		public ComplexTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_complexType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTLListener ) ((UTLListener)listener).enterComplexType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTLListener ) ((UTLListener)listener).exitComplexType(this);
		}
	}

	public final ComplexTypeContext complexType() throws RecognitionException {
		ComplexTypeContext _localctx = new ComplexTypeContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_complexType);
		try {
			setState(681);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ORDER:
				enterOuterAlt(_localctx, 1);
				{
				setState(673);
				match(ORDER);
				 ((ComplexTypeContext)_localctx).complexTypeRet =  new OrderType(); 
				}
				break;
			case TRADE:
				enterOuterAlt(_localctx, 2);
				{
				setState(675);
				match(TRADE);
				 ((ComplexTypeContext)_localctx).complexTypeRet =  new TradeType(); 
				}
				break;
			case CANDLE:
				enterOuterAlt(_localctx, 3);
				{
				setState(677);
				match(CANDLE);
				 ((ComplexTypeContext)_localctx).complexTypeRet =  new CandleType(); 
				}
				break;
			case EXCEPTION:
				enterOuterAlt(_localctx, 4);
				{
				setState(679);
				match(EXCEPTION);
				 ((ComplexTypeContext)_localctx).complexTypeRet =  new ExceptionType(); 
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

	@SuppressWarnings("CheckReturnValue")
	public static class AllTypeContext extends ParserRuleContext {
		public Type allTypeRet;
		public PrimitiveTypeContext pt;
		public ComplexTypeContext ct;
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public ComplexTypeContext complexType() {
			return getRuleContext(ComplexTypeContext.class,0);
		}
		public AllTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_allType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTLListener ) ((UTLListener)listener).enterAllType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTLListener ) ((UTLListener)listener).exitAllType(this);
		}
	}

	public final AllTypeContext allType() throws RecognitionException {
		AllTypeContext _localctx = new AllTypeContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_allType);
		try {
			setState(689);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FLOAT:
			case DOUBLE:
			case STRING:
			case BOOL:
			case VOID:
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(683);
				((AllTypeContext)_localctx).pt = primitiveType();
				 ((AllTypeContext)_localctx).allTypeRet =  ((AllTypeContext)_localctx).pt.primitiveTypeRet; 
				}
				break;
			case TRADE:
			case ORDER:
			case CANDLE:
			case EXCEPTION:
				enterOuterAlt(_localctx, 2);
				{
				setState(686);
				((AllTypeContext)_localctx).ct = complexType();
				 ((AllTypeContext)_localctx).allTypeRet =  ((AllTypeContext)_localctx).ct.complexTypeRet; 
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

	@SuppressWarnings("CheckReturnValue")
	public static class SpecialFunctionContext extends ParserRuleContext {
		public TerminalNode REFRESH_RATE() { return getToken(UTLParser.REFRESH_RATE, 0); }
		public TerminalNode CONNECT() { return getToken(UTLParser.CONNECT, 0); }
		public TerminalNode OBSERVE() { return getToken(UTLParser.OBSERVE, 0); }
		public TerminalNode GET_CANDLE() { return getToken(UTLParser.GET_CANDLE, 0); }
		public TerminalNode TERMINATE() { return getToken(UTLParser.TERMINATE, 0); }
		public TerminalNode PRINT() { return getToken(UTLParser.PRINT, 0); }
		public SpecialFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_specialFunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTLListener ) ((UTLListener)listener).enterSpecialFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTLListener ) ((UTLListener)listener).exitSpecialFunction(this);
		}
	}

	public final SpecialFunctionContext specialFunction() throws RecognitionException {
		SpecialFunctionContext _localctx = new SpecialFunctionContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_specialFunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(691);
			_la = _input.LA(1);
			if ( !(((((_la - 74)) & ~0x3f) == 0 && ((1L << (_la - 74)) & 63L) != 0)) ) {
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

	@SuppressWarnings("CheckReturnValue")
	public static class SpecialVariableContext extends ParserRuleContext {
		public TerminalNode ASK() { return getToken(UTLParser.ASK, 0); }
		public TerminalNode BID() { return getToken(UTLParser.BID, 0); }
		public TerminalNode TIME() { return getToken(UTLParser.TIME, 0); }
		public TerminalNode HIGH() { return getToken(UTLParser.HIGH, 0); }
		public TerminalNode LOW() { return getToken(UTLParser.LOW, 0); }
		public TerminalNode DIGITS() { return getToken(UTLParser.DIGITS, 0); }
		public TerminalNode VOLUME() { return getToken(UTLParser.VOLUME, 0); }
		public TerminalNode TYPE() { return getToken(UTLParser.TYPE, 0); }
		public TerminalNode TEXT() { return getToken(UTLParser.TEXT, 0); }
		public TerminalNode OPEN() { return getToken(UTLParser.OPEN, 0); }
		public TerminalNode CLOSE() { return getToken(UTLParser.CLOSE, 0); }
		public SpecialVariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_specialVariable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTLListener ) ((UTLListener)listener).enterSpecialVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTLListener ) ((UTLListener)listener).exitSpecialVariable(this);
		}
	}

	public final SpecialVariableContext specialVariable() throws RecognitionException {
		SpecialVariableContext _localctx = new SpecialVariableContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_specialVariable);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(693);
			_la = _input.LA(1);
			if ( !(((((_la - 59)) & ~0x3f) == 0 && ((1L << (_la - 59)) & 2047L) != 0)) ) {
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

	@SuppressWarnings("CheckReturnValue")
	public static class SpecialMethodContext extends ParserRuleContext {
		public TerminalNode OPEN() { return getToken(UTLParser.OPEN, 0); }
		public TerminalNode CLOSE() { return getToken(UTLParser.CLOSE, 0); }
		public SpecialMethodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_specialMethod; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTLListener ) ((UTLListener)listener).enterSpecialMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTLListener ) ((UTLListener)listener).exitSpecialMethod(this);
		}
	}

	public final SpecialMethodContext specialMethod() throws RecognitionException {
		SpecialMethodContext _localctx = new SpecialMethodContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_specialMethod);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(695);
			_la = _input.LA(1);
			if ( !(_la==OPEN || _la==CLOSE) ) {
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

	@SuppressWarnings("CheckReturnValue")
	public static class AssignContext extends ParserRuleContext {
		public TerminalNode ASSIGN() { return getToken(UTLParser.ASSIGN, 0); }
		public TerminalNode ADD_ASSIGN() { return getToken(UTLParser.ADD_ASSIGN, 0); }
		public TerminalNode SUB_ASSIGN() { return getToken(UTLParser.SUB_ASSIGN, 0); }
		public TerminalNode MUL_ASSIGN() { return getToken(UTLParser.MUL_ASSIGN, 0); }
		public TerminalNode DIV_ASSIGN() { return getToken(UTLParser.DIV_ASSIGN, 0); }
		public TerminalNode MOD_ASSIGN() { return getToken(UTLParser.MOD_ASSIGN, 0); }
		public AssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UTLListener ) ((UTLListener)listener).enterAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UTLListener ) ((UTLListener)listener).exitAssign(this);
		}
	}

	public final AssignContext assign() throws RecognitionException {
		AssignContext _localctx = new AssignContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_assign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(697);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 270582939648L) != 0)) ) {
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 19:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 13);
		case 1:
			return precpred(_ctx, 12);
		case 2:
			return precpred(_ctx, 11);
		case 3:
			return precpred(_ctx, 10);
		case 4:
			return precpred(_ctx, 9);
		case 5:
			return precpred(_ctx, 8);
		case 6:
			return precpred(_ctx, 7);
		case 7:
			return precpred(_ctx, 6);
		case 8:
			return precpred(_ctx, 16);
		case 9:
			return precpred(_ctx, 15);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001U\u02bc\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0005\u0000F\b\u0000\n\u0000\f\u0000I\t\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0003\u0001p\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002y\b\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002\u0080\b\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003\u008c\b\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003"+
		"\u0093\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004\u00a4\b\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004\u00af\b\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0005\u0004\u00b4\b\u0004\n\u0004\f\u0004\u00b7"+
		"\t\u0004\u0003\u0004\u00b9\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0003\u0004\u00be\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0005\u0004\u00c4\b\u0004\n\u0004\f\u0004\u00c7\t\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0003\u0004\u00cd\b\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005"+
		"\u0006\u00dc\b\u0006\n\u0006\f\u0006\u00df\t\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0003\u0006\u00e5\b\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u00f2\b\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007\u00f8\b\u0007\n\u0007"+
		"\f\u0007\u00fb\t\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0003\u0007\u0101\b\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u010d\b\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0005\b\u0113\b\b\n\b\f\b\u0116\t\b\u0001\b\u0001\b\u0001\b"+
		"\u0001\b\u0003\b\u011c\b\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0003\t\u0125\b\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0005"+
		"\n\u0135\b\n\n\n\f\n\u0138\t\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n"+
		"\u013e\b\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0005\n\u0145\b\n\n"+
		"\n\f\n\u0148\t\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u014e\b\n\u0003"+
		"\n\u0150\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u015b\b\u000b"+
		"\n\u000b\f\u000b\u015e\t\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0003\u000b\u0164\b\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u016f\b\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0005\f\u0177\b\f\n\f\f\f\u017a\t\f\u0001\f"+
		"\u0001\f\u0001\f\u0001\f\u0003\f\u0180\b\f\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0005\r\u0189\b\r\n\r\f\r\u018c\t\r\u0001\r"+
		"\u0001\r\u0001\r\u0001\r\u0003\r\u0192\b\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0005\r\u019b\b\r\n\r\f\r\u019e\t\r\u0001\r"+
		"\u0001\r\u0001\r\u0001\r\u0003\r\u01a4\b\r\u0003\r\u01a6\b\r\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011"+
		"\u01c0\b\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0005\u0011\u01cb\b\u0011"+
		"\n\u0011\f\u0011\u01ce\t\u0011\u0003\u0011\u01d0\b\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0003\u0012\u01db\b\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0005\u0012\u01e7\b\u0012\n\u0012\f\u0012\u01ea\t\u0012"+
		"\u0003\u0012\u01ec\b\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0003\u0013\u01ff\b\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0003\u0013\u0218\b\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0003\u0013\u0222\b\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013"+
		"\u022d\b\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u0238\b\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u0243\b\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0003\u0013\u024e\b\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u025b\b\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0003\u0013\u027e\b\u0013\u0001\u0013\u0005\u0013"+
		"\u0281\b\u0013\n\u0013\f\u0013\u0284\t\u0013\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0003\u0014\u0292\b\u0014\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0003"+
		"\u0015\u02a0\b\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0003\u0016\u02aa\b\u0016\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0003"+
		"\u0017\u02b2\b\u0017\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001"+
		"\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0000\u0001&\u001c"+
		"\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a"+
		"\u001c\u001e \"$&(*,.0246\u0000\u0005\u0001\u0000-.\u0001\u0000JO\u0001"+
		"\u0000;E\u0001\u0000DE\u0001\u0000 %\u0302\u00008\u0001\u0000\u0000\u0000"+
		"\u0002o\u0001\u0000\u0000\u0000\u0004q\u0001\u0000\u0000\u0000\u0006\u0084"+
		"\u0001\u0000\u0000\u0000\b\u0097\u0001\u0000\u0000\u0000\n\u00ce\u0001"+
		"\u0000\u0000\u0000\f\u00d1\u0001\u0000\u0000\u0000\u000e\u00e6\u0001\u0000"+
		"\u0000\u0000\u0010\u0102\u0001\u0000\u0000\u0000\u0012\u011d\u0001\u0000"+
		"\u0000\u0000\u0014\u012b\u0001\u0000\u0000\u0000\u0016\u0151\u0001\u0000"+
		"\u0000\u0000\u0018\u0165\u0001\u0000\u0000\u0000\u001a\u0181\u0001\u0000"+
		"\u0000\u0000\u001c\u01a7\u0001\u0000\u0000\u0000\u001e\u01ab\u0001\u0000"+
		"\u0000\u0000 \u01b0\u0001\u0000\u0000\u0000\"\u01b5\u0001\u0000\u0000"+
		"\u0000$\u01d3\u0001\u0000\u0000\u0000&\u0217\u0001\u0000\u0000\u0000("+
		"\u0291\u0001\u0000\u0000\u0000*\u029f\u0001\u0000\u0000\u0000,\u02a9\u0001"+
		"\u0000\u0000\u0000.\u02b1\u0001\u0000\u0000\u00000\u02b3\u0001\u0000\u0000"+
		"\u00002\u02b5\u0001\u0000\u0000\u00004\u02b7\u0001\u0000\u0000\u00006"+
		"\u02b9\u0001\u0000\u0000\u00008G\u0006\u0000\uffff\uffff\u00009:\u0003"+
		"\u0004\u0002\u0000:;\u0006\u0000\uffff\uffff\u0000;F\u0001\u0000\u0000"+
		"\u0000<=\u0003\b\u0004\u0000=>\u0006\u0000\uffff\uffff\u0000>F\u0001\u0000"+
		"\u0000\u0000?@\u0003\u000e\u0007\u0000@A\u0006\u0000\uffff\uffff\u0000"+
		"AF\u0001\u0000\u0000\u0000BC\u0003\u0010\b\u0000CD\u0006\u0000\uffff\uffff"+
		"\u0000DF\u0001\u0000\u0000\u0000E9\u0001\u0000\u0000\u0000E<\u0001\u0000"+
		"\u0000\u0000E?\u0001\u0000\u0000\u0000EB\u0001\u0000\u0000\u0000FI\u0001"+
		"\u0000\u0000\u0000GE\u0001\u0000\u0000\u0000GH\u0001\u0000\u0000\u0000"+
		"HJ\u0001\u0000\u0000\u0000IG\u0001\u0000\u0000\u0000JK\u0003\f\u0006\u0000"+
		"KL\u0006\u0000\uffff\uffff\u0000L\u0001\u0001\u0000\u0000\u0000MN\u0003"+
		"\u0006\u0003\u0000NO\u0006\u0001\uffff\uffff\u0000Op\u0001\u0000\u0000"+
		"\u0000PQ\u0003\b\u0004\u0000QR\u0006\u0001\uffff\uffff\u0000Rp\u0001\u0000"+
		"\u0000\u0000ST\u0003\u0012\t\u0000TU\u0006\u0001\uffff\uffff\u0000Up\u0001"+
		"\u0000\u0000\u0000VW\u0003\u001c\u000e\u0000WX\u0006\u0001\uffff\uffff"+
		"\u0000Xp\u0001\u0000\u0000\u0000YZ\u0003\u001e\u000f\u0000Z[\u0006\u0001"+
		"\uffff\uffff\u0000[p\u0001\u0000\u0000\u0000\\]\u0003\u0014\n\u0000]^"+
		"\u0006\u0001\uffff\uffff\u0000^p\u0001\u0000\u0000\u0000_`\u0003\u0016"+
		"\u000b\u0000`a\u0006\u0001\uffff\uffff\u0000ap\u0001\u0000\u0000\u0000"+
		"bc\u0003\u0018\f\u0000cd\u0006\u0001\uffff\uffff\u0000dp\u0001\u0000\u0000"+
		"\u0000ef\u0003\u001a\r\u0000fg\u0006\u0001\uffff\uffff\u0000gp\u0001\u0000"+
		"\u0000\u0000hi\u0003 \u0010\u0000ij\u0006\u0001\uffff\uffff\u0000jp\u0001"+
		"\u0000\u0000\u0000kl\u0003&\u0013\u0000lm\u0005\u0002\u0000\u0000mn\u0006"+
		"\u0001\uffff\uffff\u0000np\u0001\u0000\u0000\u0000oM\u0001\u0000\u0000"+
		"\u0000oP\u0001\u0000\u0000\u0000oS\u0001\u0000\u0000\u0000oV\u0001\u0000"+
		"\u0000\u0000oY\u0001\u0000\u0000\u0000o\\\u0001\u0000\u0000\u0000o_\u0001"+
		"\u0000\u0000\u0000ob\u0001\u0000\u0000\u0000oe\u0001\u0000\u0000\u0000"+
		"oh\u0001\u0000\u0000\u0000ok\u0001\u0000\u0000\u0000p\u0003\u0001\u0000"+
		"\u0000\u0000qr\u0006\u0002\uffff\uffff\u0000rs\u0003.\u0017\u0000sx\u0006"+
		"\u0002\uffff\uffff\u0000tu\u0005\n\u0000\u0000uv\u0005Q\u0000\u0000vw"+
		"\u0005\u000b\u0000\u0000wy\u0006\u0002\uffff\uffff\u0000xt\u0001\u0000"+
		"\u0000\u0000xy\u0001\u0000\u0000\u0000yz\u0001\u0000\u0000\u0000z\u007f"+
		"\u0003\n\u0005\u0000{|\u0005 \u0000\u0000|}\u0003&\u0013\u0000}~\u0006"+
		"\u0002\uffff\uffff\u0000~\u0080\u0001\u0000\u0000\u0000\u007f{\u0001\u0000"+
		"\u0000\u0000\u007f\u0080\u0001\u0000\u0000\u0000\u0080\u0081\u0001\u0000"+
		"\u0000\u0000\u0081\u0082\u0005\u0002\u0000\u0000\u0082\u0083\u0006\u0002"+
		"\uffff\uffff\u0000\u0083\u0005\u0001\u0000\u0000\u0000\u0084\u0085\u0006"+
		"\u0003\uffff\uffff\u0000\u0085\u0086\u0003.\u0017\u0000\u0086\u008b\u0006"+
		"\u0003\uffff\uffff\u0000\u0087\u0088\u0005\n\u0000\u0000\u0088\u0089\u0005"+
		"Q\u0000\u0000\u0089\u008a\u0005\u000b\u0000\u0000\u008a\u008c\u0006\u0003"+
		"\uffff\uffff\u0000\u008b\u0087\u0001\u0000\u0000\u0000\u008b\u008c\u0001"+
		"\u0000\u0000\u0000\u008c\u008d\u0001\u0000\u0000\u0000\u008d\u0092\u0003"+
		"\n\u0005\u0000\u008e\u008f\u0005 \u0000\u0000\u008f\u0090\u0003&\u0013"+
		"\u0000\u0090\u0091\u0006\u0003\uffff\uffff\u0000\u0091\u0093\u0001\u0000"+
		"\u0000\u0000\u0092\u008e\u0001\u0000\u0000\u0000\u0092\u0093\u0001\u0000"+
		"\u0000\u0000\u0093\u0094\u0001\u0000\u0000\u0000\u0094\u0095\u0005\u0002"+
		"\u0000\u0000\u0095\u0096\u0006\u0003\uffff\uffff\u0000\u0096\u0007\u0001"+
		"\u0000\u0000\u0000\u0097\u0098\u0006\u0004\uffff\uffff\u0000\u0098\u0099"+
		"\u0003*\u0015\u0000\u0099\u009a\u0006\u0004\uffff\uffff\u0000\u009a\u009b"+
		"\u0003\n\u0005\u0000\u009b\u009c\u0006\u0004\uffff\uffff\u0000\u009c\u00b8"+
		"\u0005\u0006\u0000\u0000\u009d\u009e\u0003.\u0017\u0000\u009e\u00a3\u0006"+
		"\u0004\uffff\uffff\u0000\u009f\u00a0\u0005\n\u0000\u0000\u00a0\u00a1\u0005"+
		"Q\u0000\u0000\u00a1\u00a2\u0005\u000b\u0000\u0000\u00a2\u00a4\u0006\u0004"+
		"\uffff\uffff\u0000\u00a3\u009f\u0001\u0000\u0000\u0000\u00a3\u00a4\u0001"+
		"\u0000\u0000\u0000\u00a4\u00a5\u0001\u0000\u0000\u0000\u00a5\u00a6\u0003"+
		"\n\u0005\u0000\u00a6\u00b5\u0006\u0004\uffff\uffff\u0000\u00a7\u00a8\u0005"+
		"\u0003\u0000\u0000\u00a8\u00a9\u0003.\u0017\u0000\u00a9\u00ae\u0006\u0004"+
		"\uffff\uffff\u0000\u00aa\u00ab\u0005\n\u0000\u0000\u00ab\u00ac\u0005Q"+
		"\u0000\u0000\u00ac\u00ad\u0005\u000b\u0000\u0000\u00ad\u00af\u0006\u0004"+
		"\uffff\uffff\u0000\u00ae\u00aa\u0001\u0000\u0000\u0000\u00ae\u00af\u0001"+
		"\u0000\u0000\u0000\u00af\u00b0\u0001\u0000\u0000\u0000\u00b0\u00b1\u0003"+
		"\n\u0005\u0000\u00b1\u00b2\u0006\u0004\uffff\uffff\u0000\u00b2\u00b4\u0001"+
		"\u0000\u0000\u0000\u00b3\u00a7\u0001\u0000\u0000\u0000\u00b4\u00b7\u0001"+
		"\u0000\u0000\u0000\u00b5\u00b3\u0001\u0000\u0000\u0000\u00b5\u00b6\u0001"+
		"\u0000\u0000\u0000\u00b6\u00b9\u0001\u0000\u0000\u0000\u00b7\u00b5\u0001"+
		"\u0000\u0000\u0000\u00b8\u009d\u0001\u0000\u0000\u0000\u00b8\u00b9\u0001"+
		"\u0000\u0000\u0000\u00b9\u00ba\u0001\u0000\u0000\u0000\u00ba\u00bd\u0005"+
		"\u0007\u0000\u0000\u00bb\u00bc\u0005\'\u0000\u0000\u00bc\u00be\u0005I"+
		"\u0000\u0000\u00bd\u00bb\u0001\u0000\u0000\u0000\u00bd\u00be\u0001\u0000"+
		"\u0000\u0000\u00be\u00cc\u0001\u0000\u0000\u0000\u00bf\u00c5\u0005\b\u0000"+
		"\u0000\u00c0\u00c1\u0003\u0002\u0001\u0000\u00c1\u00c2\u0006\u0004\uffff"+
		"\uffff\u0000\u00c2\u00c4\u0001\u0000\u0000\u0000\u00c3\u00c0\u0001\u0000"+
		"\u0000\u0000\u00c4\u00c7\u0001\u0000\u0000\u0000\u00c5\u00c3\u0001\u0000"+
		"\u0000\u0000\u00c5\u00c6\u0001\u0000\u0000\u0000\u00c6\u00c8\u0001\u0000"+
		"\u0000\u0000\u00c7\u00c5\u0001\u0000\u0000\u0000\u00c8\u00cd\u0005\t\u0000"+
		"\u0000\u00c9\u00ca\u0003\u0002\u0001\u0000\u00ca\u00cb\u0006\u0004\uffff"+
		"\uffff\u0000\u00cb\u00cd\u0001\u0000\u0000\u0000\u00cc\u00bf\u0001\u0000"+
		"\u0000\u0000\u00cc\u00c9\u0001\u0000\u0000\u0000\u00cd\t\u0001\u0000\u0000"+
		"\u0000\u00ce\u00cf\u0005P\u0000\u0000\u00cf\u00d0\u0006\u0005\uffff\uffff"+
		"\u0000\u00d0\u000b\u0001\u0000\u0000\u0000\u00d1\u00d2\u0006\u0006\uffff"+
		"\uffff\u0000\u00d2\u00d3\u00057\u0000\u0000\u00d3\u00d4\u00050\u0000\u0000"+
		"\u00d4\u00d5\u0006\u0006\uffff\uffff\u0000\u00d5\u00d6\u0005\u0006\u0000"+
		"\u0000\u00d6\u00e4\u0005\u0007\u0000\u0000\u00d7\u00dd\u0005\b\u0000\u0000"+
		"\u00d8\u00d9\u0003\u0002\u0001\u0000\u00d9\u00da\u0006\u0006\uffff\uffff"+
		"\u0000\u00da\u00dc\u0001\u0000\u0000\u0000\u00db\u00d8\u0001\u0000\u0000"+
		"\u0000\u00dc\u00df\u0001\u0000\u0000\u0000\u00dd\u00db\u0001\u0000\u0000"+
		"\u0000\u00dd\u00de\u0001\u0000\u0000\u0000\u00de\u00e0\u0001\u0000\u0000"+
		"\u0000\u00df\u00dd\u0001\u0000\u0000\u0000\u00e0\u00e5\u0005\t\u0000\u0000"+
		"\u00e1\u00e2\u0003\u0002\u0001\u0000\u00e2\u00e3\u0006\u0006\uffff\uffff"+
		"\u0000\u00e3\u00e5\u0001\u0000\u0000\u0000\u00e4\u00d7\u0001\u0000\u0000"+
		"\u0000\u00e4\u00e1\u0001\u0000\u0000\u0000\u00e5\r\u0001\u0000\u0000\u0000"+
		"\u00e6\u00e7\u0006\u0007\uffff\uffff\u0000\u00e7\u00e8\u00057\u0000\u0000"+
		"\u00e8\u00e9\u00051\u0000\u0000\u00e9\u00ea\u0006\u0007\uffff\uffff\u0000"+
		"\u00ea\u00eb\u0005\u0006\u0000\u0000\u00eb\u00ec\u0005F\u0000\u0000\u00ec"+
		"\u00ed\u0003\n\u0005\u0000\u00ed\u00ee\u0006\u0007\uffff\uffff\u0000\u00ee"+
		"\u00f1\u0005\u0007\u0000\u0000\u00ef\u00f0\u0005\'\u0000\u0000\u00f0\u00f2"+
		"\u0005I\u0000\u0000\u00f1\u00ef\u0001\u0000\u0000\u0000\u00f1\u00f2\u0001"+
		"\u0000\u0000\u0000\u00f2\u0100\u0001\u0000\u0000\u0000\u00f3\u00f9\u0005"+
		"\b\u0000\u0000\u00f4\u00f5\u0003\u0002\u0001\u0000\u00f5\u00f6\u0006\u0007"+
		"\uffff\uffff\u0000\u00f6\u00f8\u0001\u0000\u0000\u0000\u00f7\u00f4\u0001"+
		"\u0000\u0000\u0000\u00f8\u00fb\u0001\u0000\u0000\u0000\u00f9\u00f7\u0001"+
		"\u0000\u0000\u0000\u00f9\u00fa\u0001\u0000\u0000\u0000\u00fa\u00fc\u0001"+
		"\u0000\u0000\u0000\u00fb\u00f9\u0001\u0000\u0000\u0000\u00fc\u0101\u0005"+
		"\t\u0000\u0000\u00fd\u00fe\u0003\u0002\u0001\u0000\u00fe\u00ff\u0006\u0007"+
		"\uffff\uffff\u0000\u00ff\u0101\u0001\u0000\u0000\u0000\u0100\u00f3\u0001"+
		"\u0000\u0000\u0000\u0100\u00fd\u0001\u0000\u0000\u0000\u0101\u000f\u0001"+
		"\u0000\u0000\u0000\u0102\u0103\u00057\u0000\u0000\u0103\u0104\u00052\u0000"+
		"\u0000\u0104\u0105\u0006\b\uffff\uffff\u0000\u0105\u0106\u0005\u0006\u0000"+
		"\u0000\u0106\u0107\u0005F\u0000\u0000\u0107\u0108\u0003\n\u0005\u0000"+
		"\u0108\u0109\u0006\b\uffff\uffff\u0000\u0109\u010c\u0005\u0007\u0000\u0000"+
		"\u010a\u010b\u0005\'\u0000\u0000\u010b\u010d\u0005I\u0000\u0000\u010c"+
		"\u010a\u0001\u0000\u0000\u0000\u010c\u010d\u0001\u0000\u0000\u0000\u010d"+
		"\u011b\u0001\u0000\u0000\u0000\u010e\u0114\u0005\b\u0000\u0000\u010f\u0110"+
		"\u0003\u0002\u0001\u0000\u0110\u0111\u0006\b\uffff\uffff\u0000\u0111\u0113"+
		"\u0001\u0000\u0000\u0000\u0112\u010f\u0001\u0000\u0000\u0000\u0113\u0116"+
		"\u0001\u0000\u0000\u0000\u0114\u0112\u0001\u0000\u0000\u0000\u0114\u0115"+
		"\u0001\u0000\u0000\u0000\u0115\u0117\u0001\u0000\u0000\u0000\u0116\u0114"+
		"\u0001\u0000\u0000\u0000\u0117\u011c\u0005\t\u0000\u0000\u0118\u0119\u0003"+
		"\u0002\u0001\u0000\u0119\u011a\u0006\b\uffff\uffff\u0000\u011a\u011c\u0001"+
		"\u0000\u0000\u0000\u011b\u010e\u0001\u0000\u0000\u0000\u011b\u0118\u0001"+
		"\u0000\u0000\u0000\u011c\u0011\u0001\u0000\u0000\u0000\u011d\u011e\u0003"+
		"\n\u0005\u0000\u011e\u0124\u0006\t\uffff\uffff\u0000\u011f\u0120\u0005"+
		"\n\u0000\u0000\u0120\u0121\u0003&\u0013\u0000\u0121\u0122\u0005\u000b"+
		"\u0000\u0000\u0122\u0123\u0006\t\uffff\uffff\u0000\u0123\u0125\u0001\u0000"+
		"\u0000\u0000\u0124\u011f\u0001\u0000\u0000\u0000\u0124\u0125\u0001\u0000"+
		"\u0000\u0000\u0125\u0126\u0001\u0000\u0000\u0000\u0126\u0127\u00036\u001b"+
		"\u0000\u0127\u0128\u0003&\u0013\u0000\u0128\u0129\u0005\u0002\u0000\u0000"+
		"\u0129\u012a\u0006\t\uffff\uffff\u0000\u012a\u0013\u0001\u0000\u0000\u0000"+
		"\u012b\u012c\u0005)\u0000\u0000\u012c\u012d\u0005\u0006\u0000\u0000\u012d"+
		"\u012e\u0003&\u0013\u0000\u012e\u012f\u0005\u0007\u0000\u0000\u012f\u013d"+
		"\u0006\n\uffff\uffff\u0000\u0130\u0136\u0005\b\u0000\u0000\u0131\u0132"+
		"\u0003\u0002\u0001\u0000\u0132\u0133\u0006\n\uffff\uffff\u0000\u0133\u0135"+
		"\u0001\u0000\u0000\u0000\u0134\u0131\u0001\u0000\u0000\u0000\u0135\u0138"+
		"\u0001\u0000\u0000\u0000\u0136\u0134\u0001\u0000\u0000\u0000\u0136\u0137"+
		"\u0001\u0000\u0000\u0000\u0137\u0139\u0001\u0000\u0000\u0000\u0138\u0136"+
		"\u0001\u0000\u0000\u0000\u0139\u013e\u0005\t\u0000\u0000\u013a\u013b\u0003"+
		"\u0002\u0001\u0000\u013b\u013c\u0006\n\uffff\uffff\u0000\u013c\u013e\u0001"+
		"\u0000\u0000\u0000\u013d\u0130\u0001\u0000\u0000\u0000\u013d\u013a\u0001"+
		"\u0000\u0000\u0000\u013e\u014f\u0001\u0000\u0000\u0000\u013f\u014d\u0005"+
		"*\u0000\u0000\u0140\u0146\u0005\b\u0000\u0000\u0141\u0142\u0003\u0002"+
		"\u0001\u0000\u0142\u0143\u0006\n\uffff\uffff\u0000\u0143\u0145\u0001\u0000"+
		"\u0000\u0000\u0144\u0141\u0001\u0000\u0000\u0000\u0145\u0148\u0001\u0000"+
		"\u0000\u0000\u0146\u0144\u0001\u0000\u0000\u0000\u0146\u0147\u0001\u0000"+
		"\u0000\u0000\u0147\u0149\u0001\u0000\u0000\u0000\u0148\u0146\u0001\u0000"+
		"\u0000\u0000\u0149\u014e\u0005\t\u0000\u0000\u014a\u014b\u0003\u0002\u0001"+
		"\u0000\u014b\u014c\u0006\n\uffff\uffff\u0000\u014c\u014e\u0001\u0000\u0000"+
		"\u0000\u014d\u0140\u0001\u0000\u0000\u0000\u014d\u014a\u0001\u0000\u0000"+
		"\u0000\u014e\u0150\u0001\u0000\u0000\u0000\u014f\u013f\u0001\u0000\u0000"+
		"\u0000\u014f\u0150\u0001\u0000\u0000\u0000\u0150\u0015\u0001\u0000\u0000"+
		"\u0000\u0151\u0152\u0005,\u0000\u0000\u0152\u0153\u0005\u0006\u0000\u0000"+
		"\u0153\u0154\u0003&\u0013\u0000\u0154\u0155\u0005\u0007\u0000\u0000\u0155"+
		"\u0163\u0006\u000b\uffff\uffff\u0000\u0156\u015c\u0005\b\u0000\u0000\u0157"+
		"\u0158\u0003\u0002\u0001\u0000\u0158\u0159\u0006\u000b\uffff\uffff\u0000"+
		"\u0159\u015b\u0001\u0000\u0000\u0000\u015a\u0157\u0001\u0000\u0000\u0000"+
		"\u015b\u015e\u0001\u0000\u0000\u0000\u015c\u015a\u0001\u0000\u0000\u0000"+
		"\u015c\u015d\u0001\u0000\u0000\u0000\u015d\u015f\u0001\u0000\u0000\u0000"+
		"\u015e\u015c\u0001\u0000\u0000\u0000\u015f\u0164\u0005\t\u0000\u0000\u0160"+
		"\u0161\u0003\u0002\u0001\u0000\u0161\u0162\u0006\u000b\uffff\uffff\u0000"+
		"\u0162\u0164\u0001\u0000\u0000\u0000\u0163\u0156\u0001\u0000\u0000\u0000"+
		"\u0163\u0160\u0001\u0000\u0000\u0000\u0164\u0017\u0001\u0000\u0000\u0000"+
		"\u0165\u0166\u0006\f\uffff\uffff\u0000\u0166\u0167\u0005+\u0000\u0000"+
		"\u0167\u0168\u0005\u0006\u0000\u0000\u0168\u0169\u0003\u0002\u0001\u0000"+
		"\u0169\u016a\u0003&\u0013\u0000\u016a\u016e\u0005\u0002\u0000\u0000\u016b"+
		"\u016c\u0003&\u0013\u0000\u016c\u016d\u0006\f\uffff\uffff\u0000\u016d"+
		"\u016f\u0001\u0000\u0000\u0000\u016e\u016b\u0001\u0000\u0000\u0000\u016e"+
		"\u016f\u0001\u0000\u0000\u0000\u016f\u0170\u0001\u0000\u0000\u0000\u0170"+
		"\u0171\u0005\u0007\u0000\u0000\u0171\u017f\u0006\f\uffff\uffff\u0000\u0172"+
		"\u0178\u0005\b\u0000\u0000\u0173\u0174\u0003\u0002\u0001\u0000\u0174\u0175"+
		"\u0006\f\uffff\uffff\u0000\u0175\u0177\u0001\u0000\u0000\u0000\u0176\u0173"+
		"\u0001\u0000\u0000\u0000\u0177\u017a\u0001\u0000\u0000\u0000\u0178\u0176"+
		"\u0001\u0000\u0000\u0000\u0178\u0179\u0001\u0000\u0000\u0000\u0179\u017b"+
		"\u0001\u0000\u0000\u0000\u017a\u0178\u0001\u0000\u0000\u0000\u017b\u0180"+
		"\u0005\t\u0000\u0000\u017c\u017d\u0003\u0002\u0001\u0000\u017d\u017e\u0006"+
		"\f\uffff\uffff\u0000\u017e\u0180\u0001\u0000\u0000\u0000\u017f\u0172\u0001"+
		"\u0000\u0000\u0000\u017f\u017c\u0001\u0000\u0000\u0000\u0180\u0019\u0001"+
		"\u0000\u0000\u0000\u0181\u0182\u0006\r\uffff\uffff\u0000\u0182\u0183\u0005"+
		"&\u0000\u0000\u0183\u0191\u0006\r\uffff\uffff\u0000\u0184\u018a\u0005"+
		"\b\u0000\u0000\u0185\u0186\u0003\u0002\u0001\u0000\u0186\u0187\u0006\r"+
		"\uffff\uffff\u0000\u0187\u0189\u0001\u0000\u0000\u0000\u0188\u0185\u0001"+
		"\u0000\u0000\u0000\u0189\u018c\u0001\u0000\u0000\u0000\u018a\u0188\u0001"+
		"\u0000\u0000\u0000\u018a\u018b\u0001\u0000\u0000\u0000\u018b\u018d\u0001"+
		"\u0000\u0000\u0000\u018c\u018a\u0001\u0000\u0000\u0000\u018d\u0192\u0005"+
		"\t\u0000\u0000\u018e\u018f\u0003\u0002\u0001\u0000\u018f\u0190\u0006\r"+
		"\uffff\uffff\u0000\u0190\u0192\u0001\u0000\u0000\u0000\u0191\u0184\u0001"+
		"\u0000\u0000\u0000\u0191\u018e\u0001\u0000\u0000\u0000\u0192\u01a5\u0001"+
		"\u0000\u0000\u0000\u0193\u0194\u0005(\u0000\u0000\u0194\u0195\u0005I\u0000"+
		"\u0000\u0195\u01a3\u0005P\u0000\u0000\u0196\u019c\u0005\b\u0000\u0000"+
		"\u0197\u0198\u0003\u0002\u0001\u0000\u0198\u0199\u0006\r\uffff\uffff\u0000"+
		"\u0199\u019b\u0001\u0000\u0000\u0000\u019a\u0197\u0001\u0000\u0000\u0000"+
		"\u019b\u019e\u0001\u0000\u0000\u0000\u019c\u019a\u0001\u0000\u0000\u0000"+
		"\u019c\u019d\u0001\u0000\u0000\u0000\u019d\u019f\u0001\u0000\u0000\u0000"+
		"\u019e\u019c\u0001\u0000\u0000\u0000\u019f\u01a4\u0005\t\u0000\u0000\u01a0"+
		"\u01a1\u0003\u0002\u0001\u0000\u01a1\u01a2\u0006\r\uffff\uffff\u0000\u01a2"+
		"\u01a4\u0001\u0000\u0000\u0000\u01a3\u0196\u0001\u0000\u0000\u0000\u01a3"+
		"\u01a0\u0001\u0000\u0000\u0000\u01a4\u01a6\u0001\u0000\u0000\u0000\u01a5"+
		"\u0193\u0001\u0000\u0000\u0000\u01a5\u01a6\u0001\u0000\u0000\u0000\u01a6"+
		"\u001b\u0001\u0000\u0000\u0000\u01a7\u01a8\u0007\u0000\u0000\u0000\u01a8"+
		"\u01a9\u0006\u000e\uffff\uffff\u0000\u01a9\u01aa\u0005\u0002\u0000\u0000"+
		"\u01aa\u001d\u0001\u0000\u0000\u0000\u01ab\u01ac\u0005/\u0000\u0000\u01ac"+
		"\u01ad\u0003&\u0013\u0000\u01ad\u01ae\u0006\u000f\uffff\uffff\u0000\u01ae"+
		"\u01af\u0005\u0002\u0000\u0000\u01af\u001f\u0001\u0000\u0000\u0000\u01b0"+
		"\u01b1\u0005\'\u0000\u0000\u01b1\u01b2\u0003&\u0013\u0000\u01b2\u01b3"+
		"\u0006\u0010\uffff\uffff\u0000\u01b3\u01b4\u0005\u0002\u0000\u0000\u01b4"+
		"!\u0001\u0000\u0000\u0000\u01b5\u01bf\u0006\u0011\uffff\uffff\u0000\u01b6"+
		"\u01b7\u00030\u0018\u0000\u01b7\u01b8\u0006\u0011\uffff\uffff\u0000\u01b8"+
		"\u01c0\u0001\u0000\u0000\u0000\u01b9\u01ba\u0003,\u0016\u0000\u01ba\u01bb"+
		"\u0006\u0011\uffff\uffff\u0000\u01bb\u01c0\u0001\u0000\u0000\u0000\u01bc"+
		"\u01bd\u0003\n\u0005\u0000\u01bd\u01be\u0006\u0011\uffff\uffff\u0000\u01be"+
		"\u01c0\u0001\u0000\u0000\u0000\u01bf\u01b6\u0001\u0000\u0000\u0000\u01bf"+
		"\u01b9\u0001\u0000\u0000\u0000\u01bf\u01bc\u0001\u0000\u0000\u0000\u01c0"+
		"\u01c1\u0001\u0000\u0000\u0000\u01c1\u01c2\u0006\u0011\uffff\uffff\u0000"+
		"\u01c2\u01c3\u0005\u0006\u0000\u0000\u01c3\u01cf\u0006\u0011\uffff\uffff"+
		"\u0000\u01c4\u01c5\u0003&\u0013\u0000\u01c5\u01cc\u0006\u0011\uffff\uffff"+
		"\u0000\u01c6\u01c7\u0005\u0003\u0000\u0000\u01c7\u01c8\u0003&\u0013\u0000"+
		"\u01c8\u01c9\u0006\u0011\uffff\uffff\u0000\u01c9\u01cb\u0001\u0000\u0000"+
		"\u0000\u01ca\u01c6\u0001\u0000\u0000\u0000\u01cb\u01ce\u0001\u0000\u0000"+
		"\u0000\u01cc\u01ca\u0001\u0000\u0000\u0000\u01cc\u01cd\u0001\u0000\u0000"+
		"\u0000\u01cd\u01d0\u0001\u0000\u0000\u0000\u01ce\u01cc\u0001\u0000\u0000"+
		"\u0000\u01cf\u01c4\u0001\u0000\u0000\u0000\u01cf\u01d0\u0001\u0000\u0000"+
		"\u0000\u01d0\u01d1\u0001\u0000\u0000\u0000\u01d1\u01d2\u0005\u0007\u0000"+
		"\u0000\u01d2#\u0001\u0000\u0000\u0000\u01d3\u01d4\u0006\u0012\uffff\uffff"+
		"\u0000\u01d4\u01da\u0003\n\u0005\u0000\u01d5\u01d6\u0005\n\u0000\u0000"+
		"\u01d6\u01d7\u0003&\u0013\u0000\u01d7\u01d8\u0005\u000b\u0000\u0000\u01d8"+
		"\u01d9\u0006\u0012\uffff\uffff\u0000\u01d9\u01db\u0001\u0000\u0000\u0000"+
		"\u01da\u01d5\u0001\u0000\u0000\u0000\u01da\u01db\u0001\u0000\u0000\u0000"+
		"\u01db\u01dc\u0001\u0000\u0000\u0000\u01dc\u01dd\u0005\u0005\u0000\u0000"+
		"\u01dd\u01de\u00034\u001a\u0000\u01de\u01df\u0006\u0012\uffff\uffff\u0000"+
		"\u01df\u01eb\u0005\u0006\u0000\u0000\u01e0\u01e1\u0003&\u0013\u0000\u01e1"+
		"\u01e8\u0006\u0012\uffff\uffff\u0000\u01e2\u01e3\u0005\u0003\u0000\u0000"+
		"\u01e3\u01e4\u0003&\u0013\u0000\u01e4\u01e5\u0006\u0012\uffff\uffff\u0000"+
		"\u01e5\u01e7\u0001\u0000\u0000\u0000\u01e6\u01e2\u0001\u0000\u0000\u0000"+
		"\u01e7\u01ea\u0001\u0000\u0000\u0000\u01e8\u01e6\u0001\u0000\u0000\u0000"+
		"\u01e8\u01e9\u0001\u0000\u0000\u0000\u01e9\u01ec\u0001\u0000\u0000\u0000"+
		"\u01ea\u01e8\u0001\u0000\u0000\u0000\u01eb\u01e0\u0001\u0000\u0000\u0000"+
		"\u01eb\u01ec\u0001\u0000\u0000\u0000\u01ec\u01ed\u0001\u0000\u0000\u0000"+
		"\u01ed\u01ee\u0005\u0007\u0000\u0000\u01ee%\u0001\u0000\u0000\u0000\u01ef"+
		"\u01f0\u0006\u0013\uffff\uffff\u0000\u01f0\u01f1\u0003(\u0014\u0000\u01f1"+
		"\u01f2\u0006\u0013\uffff\uffff\u0000\u01f2\u0218\u0001\u0000\u0000\u0000"+
		"\u01f3\u01fe\u0006\u0013\uffff\uffff\u0000\u01f4\u01f5\u0005\u0013\u0000"+
		"\u0000\u01f5\u01ff\u0006\u0013\uffff\uffff\u0000\u01f6\u01f7\u0005\r\u0000"+
		"\u0000\u01f7\u01ff\u0006\u0013\uffff\uffff\u0000\u01f8\u01f9\u0005\u0019"+
		"\u0000\u0000\u01f9\u01ff\u0006\u0013\uffff\uffff\u0000\u01fa\u01fb\u0005"+
		"\u001e\u0000\u0000\u01fb\u01ff\u0006\u0013\uffff\uffff\u0000\u01fc\u01fd"+
		"\u0005\u001f\u0000\u0000\u01fd\u01ff\u0006\u0013\uffff\uffff\u0000\u01fe"+
		"\u01f4\u0001\u0000\u0000\u0000\u01fe\u01f6\u0001\u0000\u0000\u0000\u01fe"+
		"\u01f8\u0001\u0000\u0000\u0000\u01fe\u01fa\u0001\u0000\u0000\u0000\u01fe"+
		"\u01fc\u0001\u0000\u0000\u0000\u01ff\u0200\u0001\u0000\u0000\u0000\u0200"+
		"\u0201\u0003&\u0013\u000e\u0201\u0202\u0006\u0013\uffff\uffff\u0000\u0202"+
		"\u0218\u0001\u0000\u0000\u0000\u0203\u0204\u0003\n\u0005\u0000\u0204\u0205"+
		"\u0005\n\u0000\u0000\u0205\u0206\u0003&\u0013\u0000\u0206\u0207\u0005"+
		"\u000b\u0000\u0000\u0207\u0208\u0006\u0013\uffff\uffff\u0000\u0208\u0218"+
		"\u0001\u0000\u0000\u0000\u0209\u020a\u0003\n\u0005\u0000\u020a\u020b\u0006"+
		"\u0013\uffff\uffff\u0000\u020b\u0218\u0001\u0000\u0000\u0000\u020c\u020d"+
		"\u0005\u0006\u0000\u0000\u020d\u020e\u0003&\u0013\u0000\u020e\u020f\u0005"+
		"\u0007\u0000\u0000\u020f\u0210\u0006\u0013\uffff\uffff\u0000\u0210\u0218"+
		"\u0001\u0000\u0000\u0000\u0211\u0212\u0003\"\u0011\u0000\u0212\u0213\u0006"+
		"\u0013\uffff\uffff\u0000\u0213\u0218\u0001\u0000\u0000\u0000\u0214\u0215"+
		"\u0003$\u0012\u0000\u0215\u0216\u0006\u0013\uffff\uffff\u0000\u0216\u0218"+
		"\u0001\u0000\u0000\u0000\u0217\u01ef\u0001\u0000\u0000\u0000\u0217\u01f3"+
		"\u0001\u0000\u0000\u0000\u0217\u0203\u0001\u0000\u0000\u0000\u0217\u0209"+
		"\u0001\u0000\u0000\u0000\u0217\u020c\u0001\u0000\u0000\u0000\u0217\u0211"+
		"\u0001\u0000\u0000\u0000\u0217\u0214\u0001\u0000\u0000\u0000\u0218\u0282"+
		"\u0001\u0000\u0000\u0000\u0219\u021a\n\r\u0000\u0000\u021a\u0221\u0006"+
		"\u0013\uffff\uffff\u0000\u021b\u021c\u0005\u000e\u0000\u0000\u021c\u0222"+
		"\u0006\u0013\uffff\uffff\u0000\u021d\u021e\u0005\u000f\u0000\u0000\u021e"+
		"\u0222\u0006\u0013\uffff\uffff\u0000\u021f\u0220\u0005\u0010\u0000\u0000"+
		"\u0220\u0222\u0006\u0013\uffff\uffff\u0000\u0221\u021b\u0001\u0000\u0000"+
		"\u0000\u0221\u021d\u0001\u0000\u0000\u0000\u0221\u021f\u0001\u0000\u0000"+
		"\u0000\u0222\u0223\u0001\u0000\u0000\u0000\u0223\u0224\u0003&\u0013\u000e"+
		"\u0224\u0225\u0006\u0013\uffff\uffff\u0000\u0225\u0281\u0001\u0000\u0000"+
		"\u0000\u0226\u0227\n\f\u0000\u0000\u0227\u022c\u0006\u0013\uffff\uffff"+
		"\u0000\u0228\u0229\u0005\f\u0000\u0000\u0229\u022d\u0006\u0013\uffff\uffff"+
		"\u0000\u022a\u022b\u0005\r\u0000\u0000\u022b\u022d\u0006\u0013\uffff\uffff"+
		"\u0000\u022c\u0228\u0001\u0000\u0000\u0000\u022c\u022a\u0001\u0000\u0000"+
		"\u0000\u022d\u022e\u0001\u0000\u0000\u0000\u022e\u022f\u0003&\u0013\r"+
		"\u022f\u0230\u0006\u0013\uffff\uffff\u0000\u0230\u0281\u0001\u0000\u0000"+
		"\u0000\u0231\u0232\n\u000b\u0000\u0000\u0232\u0237\u0006\u0013\uffff\uffff"+
		"\u0000\u0233\u0234\u0005\u0017\u0000\u0000\u0234\u0238\u0006\u0013\uffff"+
		"\uffff\u0000\u0235\u0236\u0005\u0018\u0000\u0000\u0236\u0238\u0006\u0013"+
		"\uffff\uffff\u0000\u0237\u0233\u0001\u0000\u0000\u0000\u0237\u0235\u0001"+
		"\u0000\u0000\u0000\u0238\u0239\u0001\u0000\u0000\u0000\u0239\u023a\u0003"+
		"&\u0013\f\u023a\u023b\u0006\u0013\uffff\uffff\u0000\u023b\u0281\u0001"+
		"\u0000\u0000\u0000\u023c\u023d\n\n\u0000\u0000\u023d\u0242\u0006\u0013"+
		"\uffff\uffff\u0000\u023e\u023f\u0005\u001a\u0000\u0000\u023f\u0243\u0006"+
		"\u0013\uffff\uffff\u0000\u0240\u0241\u0005\u001b\u0000\u0000\u0241\u0243"+
		"\u0006\u0013\uffff\uffff\u0000\u0242\u023e\u0001\u0000\u0000\u0000\u0242"+
		"\u0240\u0001\u0000\u0000\u0000\u0243\u0244\u0001\u0000\u0000\u0000\u0244"+
		"\u0245\u0003&\u0013\u000b\u0245\u0246\u0006\u0013\uffff\uffff\u0000\u0246"+
		"\u0281\u0001\u0000\u0000\u0000\u0247\u0248\n\t\u0000\u0000\u0248\u024d"+
		"\u0006\u0013\uffff\uffff\u0000\u0249\u024a\u0005\u001c\u0000\u0000\u024a"+
		"\u024e\u0006\u0013\uffff\uffff\u0000\u024b\u024c\u0005\u001d\u0000\u0000"+
		"\u024c\u024e\u0006\u0013\uffff\uffff\u0000\u024d\u0249\u0001\u0000\u0000"+
		"\u0000\u024d\u024b\u0001\u0000\u0000\u0000\u024e\u024f\u0001\u0000\u0000"+
		"\u0000\u024f\u0250\u0003&\u0013\n\u0250\u0251\u0006\u0013\uffff\uffff"+
		"\u0000\u0251\u0281\u0001\u0000\u0000\u0000\u0252\u0253\n\b\u0000\u0000"+
		"\u0253\u025a\u0006\u0013\uffff\uffff\u0000\u0254\u0255\u0005\u0014\u0000"+
		"\u0000\u0255\u025b\u0006\u0013\uffff\uffff\u0000\u0256\u0257\u0005\u0015"+
		"\u0000\u0000\u0257\u025b\u0006\u0013\uffff\uffff\u0000\u0258\u0259\u0005"+
		"\u0016\u0000\u0000\u0259\u025b\u0006\u0013\uffff\uffff\u0000\u025a\u0254"+
		"\u0001\u0000\u0000\u0000\u025a\u0256\u0001\u0000\u0000\u0000\u025a\u0258"+
		"\u0001\u0000\u0000\u0000\u025b\u025c\u0001\u0000\u0000\u0000\u025c\u025d"+
		"\u0003&\u0013\t\u025d\u025e\u0006\u0013\uffff\uffff\u0000\u025e\u0281"+
		"\u0001\u0000\u0000\u0000\u025f\u0260\n\u0007\u0000\u0000\u0260\u0261\u0006"+
		"\u0013\uffff\uffff\u0000\u0261\u0262\u0005\u0011\u0000\u0000\u0262\u0263"+
		"\u0006\u0013\uffff\uffff\u0000\u0263\u0264\u0001\u0000\u0000\u0000\u0264"+
		"\u0265\u0003&\u0013\b\u0265\u0266\u0006\u0013\uffff\uffff\u0000\u0266"+
		"\u0281\u0001\u0000\u0000\u0000\u0267\u0268\n\u0006\u0000\u0000\u0268\u0269"+
		"\u0005\u0012\u0000\u0000\u0269\u026a\u0003&\u0013\u0000\u026a\u026b\u0003"+
		"&\u0013\u0000\u026b\u026c\u0006\u0013\uffff\uffff\u0000\u026c\u026d\u0005"+
		"\u0012\u0000\u0000\u026d\u026e\u0006\u0013\uffff\uffff\u0000\u026e\u026f"+
		"\u0001\u0000\u0000\u0000\u026f\u0270\u0003&\u0013\u0007\u0270\u0271\u0006"+
		"\u0013\uffff\uffff\u0000\u0271\u0281\u0001\u0000\u0000\u0000\u0272\u0273"+
		"\n\u0010\u0000\u0000\u0273\u0274\u0005\u0005\u0000\u0000\u0274\u0275\u0003"+
		"2\u0019\u0000\u0275\u0276\u0006\u0013\uffff\uffff\u0000\u0276\u0281\u0001"+
		"\u0000\u0000\u0000\u0277\u0278\n\u000f\u0000\u0000\u0278\u027d\u0006\u0013"+
		"\uffff\uffff\u0000\u0279\u027a\u0005\u001e\u0000\u0000\u027a\u027e\u0006"+
		"\u0013\uffff\uffff\u0000\u027b\u027c\u0005\u001f\u0000\u0000\u027c\u027e"+
		"\u0006\u0013\uffff\uffff\u0000\u027d\u0279\u0001\u0000\u0000\u0000\u027d"+
		"\u027b\u0001\u0000\u0000\u0000\u027e\u027f\u0001\u0000\u0000\u0000\u027f"+
		"\u0281\u0006\u0013\uffff\uffff\u0000\u0280\u0219\u0001\u0000\u0000\u0000"+
		"\u0280\u0226\u0001\u0000\u0000\u0000\u0280\u0231\u0001\u0000\u0000\u0000"+
		"\u0280\u023c\u0001\u0000\u0000\u0000\u0280\u0247\u0001\u0000\u0000\u0000"+
		"\u0280\u0252\u0001\u0000\u0000\u0000\u0280\u025f\u0001\u0000\u0000\u0000"+
		"\u0280\u0267\u0001\u0000\u0000\u0000\u0280\u0272\u0001\u0000\u0000\u0000"+
		"\u0280\u0277\u0001\u0000\u0000\u0000\u0281\u0284\u0001\u0000\u0000\u0000"+
		"\u0282\u0280\u0001\u0000\u0000\u0000\u0282\u0283\u0001\u0000\u0000\u0000"+
		"\u0283\'\u0001\u0000\u0000\u0000\u0284\u0282\u0001\u0000\u0000\u0000\u0285"+
		"\u0286\u0005Q\u0000\u0000\u0286\u0292\u0006\u0014\uffff\uffff\u0000\u0287"+
		"\u0288\u0005R\u0000\u0000\u0288\u0292\u0006\u0014\uffff\uffff\u0000\u0289"+
		"\u028a\u0005T\u0000\u0000\u028a\u0292\u0006\u0014\uffff\uffff\u0000\u028b"+
		"\u028c\u0005S\u0000\u0000\u028c\u0292\u0006\u0014\uffff\uffff\u0000\u028d"+
		"\u028e\u0005:\u0000\u0000\u028e\u0292\u0006\u0014\uffff\uffff\u0000\u028f"+
		"\u0290\u00059\u0000\u0000\u0290\u0292\u0006\u0014\uffff\uffff\u0000\u0291"+
		"\u0285\u0001\u0000\u0000\u0000\u0291\u0287\u0001\u0000\u0000\u0000\u0291"+
		"\u0289\u0001\u0000\u0000\u0000\u0291\u028b\u0001\u0000\u0000\u0000\u0291"+
		"\u028d\u0001\u0000\u0000\u0000\u0291\u028f\u0001\u0000\u0000\u0000\u0292"+
		")\u0001\u0000\u0000\u0000\u0293\u0294\u00053\u0000\u0000\u0294\u02a0\u0006"+
		"\u0015\uffff\uffff\u0000\u0295\u0296\u00054\u0000\u0000\u0296\u02a0\u0006"+
		"\u0015\uffff\uffff\u0000\u0297\u0298\u00058\u0000\u0000\u0298\u02a0\u0006"+
		"\u0015\uffff\uffff\u0000\u0299\u029a\u00056\u0000\u0000\u029a\u02a0\u0006"+
		"\u0015\uffff\uffff\u0000\u029b\u029c\u00055\u0000\u0000\u029c\u02a0\u0006"+
		"\u0015\uffff\uffff\u0000\u029d\u029e\u00057\u0000\u0000\u029e\u02a0\u0006"+
		"\u0015\uffff\uffff\u0000\u029f\u0293\u0001\u0000\u0000\u0000\u029f\u0295"+
		"\u0001\u0000\u0000\u0000\u029f\u0297\u0001\u0000\u0000\u0000\u029f\u0299"+
		"\u0001\u0000\u0000\u0000\u029f\u029b\u0001\u0000\u0000\u0000\u029f\u029d"+
		"\u0001\u0000\u0000\u0000\u02a0+\u0001\u0000\u0000\u0000\u02a1\u02a2\u0005"+
		"G\u0000\u0000\u02a2\u02aa\u0006\u0016\uffff\uffff\u0000\u02a3\u02a4\u0005"+
		"F\u0000\u0000\u02a4\u02aa\u0006\u0016\uffff\uffff\u0000\u02a5\u02a6\u0005"+
		"H\u0000\u0000\u02a6\u02aa\u0006\u0016\uffff\uffff\u0000\u02a7\u02a8\u0005"+
		"I\u0000\u0000\u02a8\u02aa\u0006\u0016\uffff\uffff\u0000\u02a9\u02a1\u0001"+
		"\u0000\u0000\u0000\u02a9\u02a3\u0001\u0000\u0000\u0000\u02a9\u02a5\u0001"+
		"\u0000\u0000\u0000\u02a9\u02a7\u0001\u0000\u0000\u0000\u02aa-\u0001\u0000"+
		"\u0000\u0000\u02ab\u02ac\u0003*\u0015\u0000\u02ac\u02ad\u0006\u0017\uffff"+
		"\uffff\u0000\u02ad\u02b2\u0001\u0000\u0000\u0000\u02ae\u02af\u0003,\u0016"+
		"\u0000\u02af\u02b0\u0006\u0017\uffff\uffff\u0000\u02b0\u02b2\u0001\u0000"+
		"\u0000\u0000\u02b1\u02ab\u0001\u0000\u0000\u0000\u02b1\u02ae\u0001\u0000"+
		"\u0000\u0000\u02b2/\u0001\u0000\u0000\u0000\u02b3\u02b4\u0007\u0001\u0000"+
		"\u0000\u02b41\u0001\u0000\u0000\u0000\u02b5\u02b6\u0007\u0002\u0000\u0000"+
		"\u02b63\u0001\u0000\u0000\u0000\u02b7\u02b8\u0007\u0003\u0000\u0000\u02b8"+
		"5\u0001\u0000\u0000\u0000\u02b9\u02ba\u0007\u0004\u0000\u0000\u02ba7\u0001"+
		"\u0000\u0000\u0000;EGox\u007f\u008b\u0092\u00a3\u00ae\u00b5\u00b8\u00bd"+
		"\u00c5\u00cc\u00dd\u00e4\u00f1\u00f9\u0100\u010c\u0114\u011b\u0124\u0136"+
		"\u013d\u0146\u014d\u014f\u015c\u0163\u016e\u0178\u017f\u018a\u0191\u019c"+
		"\u01a3\u01a5\u01bf\u01cc\u01cf\u01da\u01e8\u01eb\u01fe\u0217\u0221\u022c"+
		"\u0237\u0242\u024d\u025a\u027d\u0280\u0282\u0291\u029f\u02a9\u02b1";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}