/*  1:   */ package com.cognizant.cognizantits.qcconnection.qcupdation;
/*  2:   */ 
/*  3:   */ import com4j.ComEnum;
/*  4:   */ 
/*  5:   */ public enum tagTDAPI_LIBRARY_ASYNCH_RETVAL
/*  6:   */   implements ComEnum
/*  7:   */ {
/*  8:11 */   LIBRARY_ASYNCH_RETVAL_THREAD_NOT_SPAWNED(
/*  9:   */   
/* 10:   */ 
/* 11:   */ 
/* 12:   */ 
/* 13:   */ 
/* 14:   */ 
/* 15:   */ 
/* 16:19 */     -3),  LIBRARY_ASYNCH_RETVAL_WRONG_LIBTYPE(
/* 17:   */   
/* 18:   */ 
/* 19:   */ 
/* 20:   */ 
/* 21:   */ 
/* 22:   */ 
/* 23:   */ 
/* 24:28 */     -2),  LIBRARY_ASYNCH_RETVAL_ALREADY_RUNNING(
/* 25:   */   
/* 26:   */ 
/* 27:   */ 
/* 28:   */ 
/* 29:   */ 
/* 30:   */ 
/* 31:   */ 
/* 32:37 */     -1),  LIBRARY_ASYNCH_RETVAL_SUCCESFUL(
/* 33:   */   
/* 34:   */ 
/* 35:   */ 
/* 36:   */ 
/* 37:   */ 
/* 38:   */ 
/* 39:   */ 
/* 40:46 */     1);
/* 41:   */   
/* 42:   */   private final int value;
/* 43:   */   
/* 44:   */   private tagTDAPI_LIBRARY_ASYNCH_RETVAL(int value)
/* 45:   */   {
/* 46:50 */     this.value = value;
/* 47:   */   }
/* 48:   */   
/* 49:   */   public int comEnumValue()
/* 50:   */   {
/* 51:51 */     return this.value;
/* 52:   */   }
/* 53:   */ }


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.tagTDAPI_LIBRARY_ASYNCH_RETVAL
 * JD-Core Version:    0.7.0.1
 */