.class public UTL
.super java/lang/Object
		
.field public balance I
.field public tick_counts I
		
.method public <init>()V
		aload_0
		invokespecial java/lang/Object/<init>()V
		return
.end method
		
.method public OnInit(LTrade;)V
.limit stack 128
.limit locals 128
		new Order
		dup
		ldc "SELL"
		bipush 100
		bipush 100
		bipush 10
		invokespecial Order/<init>(Ljava/lang/String;III)V
		astore 2
		return
.end method
		
.method public OnInit(LTrade;)V
.limit stack 128
.limit locals 128
		new Order
		dup
		ldc "BUY"
		bipush 200
		bipush 50
		bipush 5
		invokespecial Order/<init>(Ljava/lang/String;III)V
		astore 2
		new Order
		dup
		ldc "SELL"
		bipush 100
		bipush 100
		bipush 10
		invokespecial Order/<init>(Ljava/lang/String;III)V
		astore 3
		return
.end method
		
.method public OnStart(LTrade;)V
.limit stack 128
.limit locals 128
		aload 1
		invokevirtual LTrade/getBid()F
		fstore 2
		
		aload 1
		invokevirtual LTrade/getAsk()D
		fstore 3
		
		bipush 100
		fstore 4
		
		bipush 250
		fstore 5
		
		bipush 20
		fstore 6
		
		new Order
		dup
		ldc "BUY"
		fload 4
		fload 5
		fload 6
		invokespecial Order/<init>(Ljava/lang/String;III)V
		astore 7
		
		fload 5
		fload 6
		idiv
		fstore 8
		
		return
.end method
		
.method public OnStart(LTrade;)V
.limit stack 128
.limit locals 128
		bipush 100
		invokevirtual LYourClass/GetCandle(I)V
		return
.end method
		
.method public static Main([Ljava/lang/String;)V
.limit stack 128
.limit locals 128
		ldc "admin"
		astore 1
		
		aload 1
		ldc "password"
		invokestatic LYourClass/Connect(Ljava/lang/String;Ljava/lang/String;)V
		ldc "USDETH"
		invokestatic LYourClass/Observe(Ljava/lang/String;)LTrade;
		astore 2
		
		aload 2
		invokevirtual LTrade/getDigits()I
		istore 3
		
		aload 2
		invokevirtual LTrade/getDigits()I
		astore 3
		
		ldc "IRRETH"
		invokestatic LYourClass/Observe(Ljava/lang/String;)LTrade;
		astore 4
		
		return
.end method
		
