/*  1:   */ package com.cognizant.cognizantits.qcconnection.qcupdation;
/*  2:   */ 
/*  3:   */ import com4j.ComEnum;
/*  4:   */ 
/*  5:   */ public enum TDAPI_COMPARISON_CHANGE_TYPES
/*  6:   */   implements ComEnum
/*  7:   */ {
/*  8:11 */   COMPARISON_CHANGE_TYPE_NO_CHANGE(
/*  9:   */   
/* 10:   */ 
/* 11:   */ 
/* 12:   */ 
/* 13:   */ 
/* 14:   */ 
/* 15:   */ 
/* 16:19 */     0),  COMPARISON_CHANGE_TYPE_ADDED(
/* 17:   */   
/* 18:   */ 
/* 19:   */ 
/* 20:   */ 
/* 21:   */ 
/* 22:   */ 
/* 23:   */ 
/* 24:28 */     1),  COMPARISON_CHANGE_TYPE_MODIFIED(
/* 25:   */   
/* 26:   */ 
/* 27:   */ 
/* 28:   */ 
/* 29:   */ 
/* 30:   */ 
/* 31:   */ 
/* 32:37 */     2),  COMPARISON_CHANGE_TYPE_MOVED(
/* 33:   */   
/* 34:   */ 
/* 35:   */ 
/* 36:   */ 
/* 37:   */ 
/* 38:   */ 
/* 39:   */ 
/* 40:46 */     4),  COMPARISON_CHANGE_TYPE_DELETED(
/* 41:   */   
/* 42:   */ 
/* 43:   */ 
/* 44:   */ 
/* 45:   */ 
/* 46:   */ 
/* 47:   */ 
/* 48:55 */     8),  COMPARISON_CHANGE_TYPE_ACTUALLY_MOVED(
/* 49:   */   
/* 50:   */ 
/* 51:   */ 
/* 52:   */ 
/* 53:   */ 
/* 54:   */ 
/* 55:   */ 
/* 56:64 */     20),  COMPARISON_CHANGE_TYPE_MOVED_AND_MODIFIED(
/* 57:   */   
/* 58:   */ 
/* 59:   */ 
/* 60:   */ 
/* 61:   */ 
/* 62:   */ 
/* 63:   */ 
/* 64:73 */     6);
/* 65:   */   
/* 66:   */   private final int value;
/* 67:   */   
/* 68:   */   private TDAPI_COMPARISON_CHANGE_TYPES(int value)
/* 69:   */   {
/* 70:77 */     this.value = value;
/* 71:   */   }
/* 72:   */   
/* 73:   */   public int comEnumValue()
/* 74:   */   {
/* 75:78 */     return this.value;
/* 76:   */   }
/* 77:   */ }


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.TDAPI_COMPARISON_CHANGE_TYPES
 * JD-Core Version:    0.7.0.1
 */