/*   1:    */ package com.cognizant.cognizantits.qcconnection.qcupdation;
/*   2:    */ 
/*   3:    */ import com4j.ComEnum;
/*   4:    */ 
/*   5:    */ public enum tagTDAPI_DIRECTORY
/*   6:    */   implements ComEnum
/*   7:    */ {
/*   8:  8 */   TDOLE_PROGECT_DIRECTORY(
/*   9:    */   
/*  10:    */ 
/*  11:    */ 
/*  12:    */ 
/*  13:    */ 
/*  14:    */ 
/*  15:    */ 
/*  16: 16 */     0),  TDOLE_PROJECT_DIRECTORY(
/*  17:    */   
/*  18:    */ 
/*  19:    */ 
/*  20:    */ 
/*  21:    */ 
/*  22:    */ 
/*  23:    */ 
/*  24: 25 */     0),  TDOLE_BIN_DIRECTORY(
/*  25:    */   
/*  26:    */ 
/*  27:    */ 
/*  28:    */ 
/*  29:    */ 
/*  30:    */ 
/*  31:    */ 
/*  32: 34 */     1),  TDOLE_TEST_DIRECTORY(
/*  33:    */   
/*  34:    */ 
/*  35:    */ 
/*  36:    */ 
/*  37:    */ 
/*  38:    */ 
/*  39:    */ 
/*  40: 43 */     2),  TDOLE_ATTACH_DIRECTORY(
/*  41:    */   
/*  42:    */ 
/*  43:    */ 
/*  44:    */ 
/*  45:    */ 
/*  46:    */ 
/*  47:    */ 
/*  48: 52 */     3),  TDOLE_USER_DIRECTORIES(
/*  49:    */   
/*  50:    */ 
/*  51:    */ 
/*  52:    */ 
/*  53:    */ 
/*  54:    */ 
/*  55:    */ 
/*  56: 61 */     4),  TDOLE_SHARED_DIRECTORY(
/*  57:    */   
/*  58:    */ 
/*  59:    */ 
/*  60:    */ 
/*  61:    */ 
/*  62:    */ 
/*  63:    */ 
/*  64: 70 */     128),  TDOLE_CHECKOUT_DIRECTORY(
/*  65:    */   
/*  66:    */ 
/*  67:    */ 
/*  68:    */ 
/*  69:    */ 
/*  70:    */ 
/*  71:    */ 
/*  72: 79 */     8),  TDOLE_VIEW_DIRECTORY(
/*  73:    */   
/*  74:    */ 
/*  75:    */ 
/*  76:    */ 
/*  77:    */ 
/*  78:    */ 
/*  79:    */ 
/*  80: 88 */     16),  TDOLE_VCSDB_DIRECTORY(
/*  81:    */   
/*  82:    */ 
/*  83:    */ 
/*  84:    */ 
/*  85:    */ 
/*  86:    */ 
/*  87:    */ 
/*  88: 97 */     32),  TDOLE_SITE_REPOS_DIRECTORY(
/*  89:    */   
/*  90:    */ 
/*  91:    */ 
/*  92:    */ 
/*  93:    */ 
/*  94:    */ 
/*  95:    */ 
/*  96:106 */     64),  TDOLE_RESOURCE_DIRECTORY(
/*  97:    */   
/*  98:    */ 
/*  99:    */ 
/* 100:    */ 
/* 101:    */ 
/* 102:    */ 
/* 103:    */ 
/* 104:115 */     256);
/* 105:    */   
/* 106:    */   private final int value;
/* 107:    */   
/* 108:    */   private tagTDAPI_DIRECTORY(int value)
/* 109:    */   {
/* 110:119 */     this.value = value;
/* 111:    */   }
/* 112:    */   
/* 113:    */   public int comEnumValue()
/* 114:    */   {
/* 115:120 */     return this.value;
/* 116:    */   }
/* 117:    */ }


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.tagTDAPI_DIRECTORY
 * JD-Core Version:    0.7.0.1
 */