/*  1:   */ package com.cognizant.cognizantits.qcconnection.qcupdation;
/*  2:   */ 
/*  3:   */ import com4j.ComEnum;
/*  4:   */ 
/*  5:   */ public enum TDAPI_PURGE_RUNS
/*  6:   */   implements ComEnum
/*  7:   */ {
/*  8:11 */   TDDAY_PURGE(
/*  9:   */   
/* 10:   */ 
/* 11:   */ 
/* 12:   */ 
/* 13:   */ 
/* 14:   */ 
/* 15:   */ 
/* 16:19 */     1),  TDWEEK_PURGE(
/* 17:   */   
/* 18:   */ 
/* 19:   */ 
/* 20:   */ 
/* 21:   */ 
/* 22:   */ 
/* 23:   */ 
/* 24:28 */     2),  TDMONTH_PURGE(
/* 25:   */   
/* 26:   */ 
/* 27:   */ 
/* 28:   */ 
/* 29:   */ 
/* 30:   */ 
/* 31:   */ 
/* 32:37 */     3),  TDYEAR_PURGE(
/* 33:   */   
/* 34:   */ 
/* 35:   */ 
/* 36:   */ 
/* 37:   */ 
/* 38:   */ 
/* 39:   */ 
/* 40:46 */     4),  TDDATE_PURGE(
/* 41:   */   
/* 42:   */ 
/* 43:   */ 
/* 44:   */ 
/* 45:   */ 
/* 46:   */ 
/* 47:   */ 
/* 48:55 */     5);
/* 49:   */   
/* 50:   */   private final int value;
/* 51:   */   
/* 52:   */   private TDAPI_PURGE_RUNS(int value)
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
 * Qualified Name:     qcupdation.TDAPI_PURGE_RUNS
 * JD-Core Version:    0.7.0.1
 */