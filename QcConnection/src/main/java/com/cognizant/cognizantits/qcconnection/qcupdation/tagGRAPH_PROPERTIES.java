/*   1:    */ package com.cognizant.cognizantits.qcconnection.qcupdation;
/*   2:    */ 
/*   3:    */ import com4j.ComEnum;
/*   4:    */ 
/*   5:    */ public enum tagGRAPH_PROPERTIES
/*   6:    */   implements ComEnum
/*   7:    */ {
/*   8:  8 */   GRAPH_XAXIS(
/*   9:    */   
/*  10:    */ 
/*  11:    */ 
/*  12:    */ 
/*  13:    */ 
/*  14:    */ 
/*  15:    */ 
/*  16: 16 */     0),  GRAPH_GROUP_BY(
/*  17:    */   
/*  18:    */ 
/*  19:    */ 
/*  20:    */ 
/*  21:    */ 
/*  22:    */ 
/*  23:    */ 
/*  24: 25 */     1),  GRAPH_SUM_OF(
/*  25:    */   
/*  26:    */ 
/*  27:    */ 
/*  28:    */ 
/*  29:    */ 
/*  30:    */ 
/*  31:    */ 
/*  32: 34 */     2),  GRAPH_START_DATE(
/*  33:    */   
/*  34:    */ 
/*  35:    */ 
/*  36:    */ 
/*  37:    */ 
/*  38:    */ 
/*  39:    */ 
/*  40: 43 */     3),  GRAPH_SHOW_NOT_COVERED_PARENTS(
/*  41:    */   
/*  42:    */ 
/*  43:    */ 
/*  44:    */ 
/*  45:    */ 
/*  46:    */ 
/*  47:    */ 
/*  48: 52 */     4),  GRAPH_TEST_SET_ID(
/*  49:    */   
/*  50:    */ 
/*  51:    */ 
/*  52:    */ 
/*  53:    */ 
/*  54:    */ 
/*  55:    */ 
/*  56: 61 */     5),  GRAPH_XAXIS_SHOW_FULL_PATH(
/*  57:    */   
/*  58:    */ 
/*  59:    */ 
/*  60:    */ 
/*  61:    */ 
/*  62:    */ 
/*  63:    */ 
/*  64: 70 */     8),  GRAPH_GROUP_BY_SHOW_FULL_PATH(
/*  65:    */   
/*  66:    */ 
/*  67:    */ 
/*  68:    */ 
/*  69:    */ 
/*  70:    */ 
/*  71:    */ 
/*  72: 79 */     9),  GRAPH_CYCLE(
/*  73:    */   
/*  74:    */ 
/*  75:    */ 
/*  76:    */ 
/*  77:    */ 
/*  78:    */ 
/*  79:    */ 
/*  80: 88 */     10),  GRAPH_RELEASE(
/*  81:    */   
/*  82:    */ 
/*  83:    */ 
/*  84:    */ 
/*  85:    */ 
/*  86:    */ 
/*  87:    */ 
/*  88: 97 */     11),  GRAPH_PROJECTS(
/*  89:    */   
/*  90:    */ 
/*  91:    */ 
/*  92:    */ 
/*  93:    */ 
/*  94:    */ 
/*  95:    */ 
/*  96:106 */     12);
/*  97:    */   
/*  98:    */   private final int value;
/*  99:    */   
/* 100:    */   private tagGRAPH_PROPERTIES(int value)
/* 101:    */   {
/* 102:110 */     this.value = value;
/* 103:    */   }
/* 104:    */   
/* 105:    */   public int comEnumValue()
/* 106:    */   {
/* 107:111 */     return this.value;
/* 108:    */   }
/* 109:    */ }


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.tagGRAPH_PROPERTIES
 * JD-Core Version:    0.7.0.1
 */