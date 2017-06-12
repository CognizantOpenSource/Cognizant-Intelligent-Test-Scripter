/*  1:   */ package com.cognizant.cognizantits.qcconnection.qcupdation;
/*  2:   */ 
/*  3:   */ import com4j.ComEnum;
/*  4:   */ 
/*  5:   */ public enum tagTDAPI_LIBRARY_ASYNCH_STATE
/*  6:   */   implements ComEnum
/*  7:   */ {
/*  8:11 */   LIB_ASYNCH_STATE_ERROR(
/*  9:   */   
/* 10:   */ 
/* 11:   */ 
/* 12:   */ 
/* 13:   */ 
/* 14:   */ 
/* 15:   */ 
/* 16:19 */     -1),  LIB_ASYNCH_STATE_NOT_IMPORTED_YET(
/* 17:   */   
/* 18:   */ 
/* 19:   */ 
/* 20:   */ 
/* 21:   */ 
/* 22:   */ 
/* 23:   */ 
/* 24:28 */     0),  LIB_ASYNCH_STATE_STABLE(
/* 25:   */   
/* 26:   */ 
/* 27:   */ 
/* 28:   */ 
/* 29:   */ 
/* 30:   */ 
/* 31:   */ 
/* 32:37 */     1),  LIB_ASYNCH_STATE_IMPORT_IN_PROGRESS(
/* 33:   */   
/* 34:   */ 
/* 35:   */ 
/* 36:   */ 
/* 37:   */ 
/* 38:   */ 
/* 39:   */ 
/* 40:46 */     2),  LIB_ASYNCH_STATE_SYNCHING(
/* 41:   */   
/* 42:   */ 
/* 43:   */ 
/* 44:   */ 
/* 45:   */ 
/* 46:   */ 
/* 47:   */ 
/* 48:55 */     3);
/* 49:   */   
/* 50:   */   private final int value;
/* 51:   */   
/* 52:   */   private tagTDAPI_LIBRARY_ASYNCH_STATE(int value)
/* 53:   */   {
/* 54:59 */     this.value = value;
/* 55:   */   }
/* 56:   */   
/* 57:   */   public int comEnumValue()
/* 58:   */   {
/* 59:60 */     return this.value;
/* 60:   */   }
/* 61:   */ }


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.tagTDAPI_LIBRARY_ASYNCH_STATE
 * JD-Core Version:    0.7.0.1
 */