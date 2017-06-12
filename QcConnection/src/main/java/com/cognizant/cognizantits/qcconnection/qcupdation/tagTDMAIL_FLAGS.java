/*  1:   */ package com.cognizant.cognizantits.qcconnection.qcupdation;
/*  2:   */ 
/*  3:   */ import com4j.ComEnum;
/*  4:   */ 
/*  5:   */ public enum tagTDMAIL_FLAGS
/*  6:   */   implements ComEnum
/*  7:   */ {
/*  8: 8 */   TDMAIL_ATTACHMENT(
/*  9:   */   
/* 10:   */ 
/* 11:   */ 
/* 12:   */ 
/* 13:   */ 
/* 14:   */ 
/* 15:   */ 
/* 16:16 */     1),  TDMAIL_HISTORY(
/* 17:   */   
/* 18:   */ 
/* 19:   */ 
/* 20:   */ 
/* 21:   */ 
/* 22:   */ 
/* 23:   */ 
/* 24:25 */     2),  TDMAIL_TEXT(
/* 25:   */   
/* 26:   */ 
/* 27:   */ 
/* 28:   */ 
/* 29:   */ 
/* 30:   */ 
/* 31:   */ 
/* 32:34 */     4),  TDMAIL_DES_STEP(
/* 33:   */   
/* 34:   */ 
/* 35:   */ 
/* 36:   */ 
/* 37:   */ 
/* 38:   */ 
/* 39:   */ 
/* 40:43 */     8),  TDMAIL_COVER_TEST(
/* 41:   */   
/* 42:   */ 
/* 43:   */ 
/* 44:   */ 
/* 45:   */ 
/* 46:   */ 
/* 47:   */ 
/* 48:52 */     16),  TDMAIL_SINGLEMAIL(
/* 49:   */   
/* 50:   */ 
/* 51:   */ 
/* 52:   */ 
/* 53:   */ 
/* 54:   */ 
/* 55:   */ 
/* 56:61 */     32),  TDMAIL_COMMENT_AS_BODY(
/* 57:   */   
/* 58:   */ 
/* 59:   */ 
/* 60:   */ 
/* 61:   */ 
/* 62:   */ 
/* 63:   */ 
/* 64:70 */     64),  TDMAIL_TRACE_REQ(
/* 65:   */   
/* 66:   */ 
/* 67:   */ 
/* 68:   */ 
/* 69:   */ 
/* 70:   */ 
/* 71:   */ 
/* 72:79 */     128);
/* 73:   */   
/* 74:   */   private final int value;
/* 75:   */   
/* 76:   */   private tagTDMAIL_FLAGS(int value)
/* 77:   */   {
/* 78:83 */     this.value = value;
/* 79:   */   }
/* 80:   */   
/* 81:   */   public int comEnumValue()
/* 82:   */   {
/* 83:84 */     return this.value;
/* 84:   */   }
/* 85:   */ }


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.tagTDMAIL_FLAGS
 * JD-Core Version:    0.7.0.1
 */