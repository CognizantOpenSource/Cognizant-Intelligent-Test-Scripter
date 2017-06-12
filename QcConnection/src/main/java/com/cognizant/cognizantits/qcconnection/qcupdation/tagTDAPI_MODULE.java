/*   1:    */ package com.cognizant.cognizantits.qcconnection.qcupdation;
/*   2:    */ 
/*   3:    */ import com4j.ComEnum;
/*   4:    */ 
/*   5:    */ public enum tagTDAPI_MODULE
/*   6:    */   implements ComEnum
/*   7:    */ {
/*   8:  8 */   MODULE_INVALID(
/*   9:    */   
/*  10:    */ 
/*  11:    */ 
/*  12:    */ 
/*  13:    */ 
/*  14:    */ 
/*  15:    */ 
/*  16: 16 */     -1),  MODULE_DEFECT(
/*  17:    */   
/*  18:    */ 
/*  19:    */ 
/*  20:    */ 
/*  21:    */ 
/*  22:    */ 
/*  23:    */ 
/*  24: 25 */     0),  MODULE_TEST_PLANNING(
/*  25:    */   
/*  26:    */ 
/*  27:    */ 
/*  28:    */ 
/*  29:    */ 
/*  30:    */ 
/*  31:    */ 
/*  32: 34 */     1),  MODULE_TEST_EXECUTION(
/*  33:    */   
/*  34:    */ 
/*  35:    */ 
/*  36:    */ 
/*  37:    */ 
/*  38:    */ 
/*  39:    */ 
/*  40: 43 */     2),  MODULE_REQUIREMENT(
/*  41:    */   
/*  42:    */ 
/*  43:    */ 
/*  44:    */ 
/*  45:    */ 
/*  46:    */ 
/*  47:    */ 
/*  48: 52 */     3),  MODULE_COLLABORATION(
/*  49:    */   
/*  50:    */ 
/*  51:    */ 
/*  52:    */ 
/*  53:    */ 
/*  54:    */ 
/*  55:    */ 
/*  56: 61 */     4),  MODULE_DASHBOARD(
/*  57:    */   
/*  58:    */ 
/*  59:    */ 
/*  60:    */ 
/*  61:    */ 
/*  62:    */ 
/*  63:    */ 
/*  64: 70 */     5),  MODULE_COMPONENTS(
/*  65:    */   
/*  66:    */ 
/*  67:    */ 
/*  68:    */ 
/*  69:    */ 
/*  70:    */ 
/*  71:    */ 
/*  72: 79 */     6),  MODULE_RELEASE(
/*  73:    */   
/*  74:    */ 
/*  75:    */ 
/*  76:    */ 
/*  77:    */ 
/*  78:    */ 
/*  79:    */ 
/*  80: 88 */     7),  MODULE_RELEASE_CYCLE(
/*  81:    */   
/*  82:    */ 
/*  83:    */ 
/*  84:    */ 
/*  85:    */ 
/*  86:    */ 
/*  87:    */ 
/*  88: 97 */     8),  MODULE_DATATYPE(
/*  89:    */   
/*  90:    */ 
/*  91:    */ 
/*  92:    */ 
/*  93:    */ 
/*  94:    */ 
/*  95:    */ 
/*  96:106 */     9);
/*  97:    */   
/*  98:    */   private final int value;
/*  99:    */   
/* 100:    */   private tagTDAPI_MODULE(int value)
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
 * Qualified Name:     qcupdation.tagTDAPI_MODULE
 * JD-Core Version:    0.7.0.1
 */