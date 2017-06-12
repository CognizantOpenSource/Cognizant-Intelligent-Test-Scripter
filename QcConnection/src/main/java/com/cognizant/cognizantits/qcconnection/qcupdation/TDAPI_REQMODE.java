/*  1:   */ package com.cognizant.cognizantits.qcconnection.qcupdation;
/*  2:   */ 
/*  3:   */ import com4j.ComEnum;
/*  4:   */ 
/*  5:   */ public enum TDAPI_REQMODE
/*  6:   */   implements ComEnum
/*  7:   */ {
/*  8:11 */   TDREQMODE_REC(
/*  9:   */   
/* 10:   */ 
/* 11:   */ 
/* 12:   */ 
/* 13:   */ 
/* 14:   */ 
/* 15:   */ 
/* 16:19 */     1),  TDREQMODE_SMART(
/* 17:   */   
/* 18:   */ 
/* 19:   */ 
/* 20:   */ 
/* 21:   */ 
/* 22:   */ 
/* 23:   */ 
/* 24:28 */     2),  TDREQMODE_REM_REM_ALL(
/* 25:   */   
/* 26:   */ 
/* 27:   */ 
/* 28:   */ 
/* 29:   */ 
/* 30:   */ 
/* 31:   */ 
/* 32:37 */     4),  TDREQMODE_FIND_START_WITH(
/* 33:   */   
/* 34:   */ 
/* 35:   */ 
/* 36:   */ 
/* 37:   */ 
/* 38:   */ 
/* 39:   */ 
/* 40:46 */     8),  TDREQMODE_FIND_EXACT(
/* 41:   */   
/* 42:   */ 
/* 43:   */ 
/* 44:   */ 
/* 45:   */ 
/* 46:   */ 
/* 47:   */ 
/* 48:55 */     16),  TDREQMODE_FIND_ANYWHERE(
/* 49:   */   
/* 50:   */ 
/* 51:   */ 
/* 52:   */ 
/* 53:   */ 
/* 54:   */ 
/* 55:   */ 
/* 56:64 */     32);
/* 57:   */   
/* 58:   */   private final int value;
/* 59:   */   
/* 60:   */   private TDAPI_REQMODE(int value)
/* 61:   */   {
/* 62:68 */     this.value = value;
/* 63:   */   }
/* 64:   */   
/* 65:   */   public int comEnumValue()
/* 66:   */   {
/* 67:69 */     return this.value;
/* 68:   */   }
/* 69:   */ }


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.TDAPI_REQMODE
 * JD-Core Version:    0.7.0.1
 */