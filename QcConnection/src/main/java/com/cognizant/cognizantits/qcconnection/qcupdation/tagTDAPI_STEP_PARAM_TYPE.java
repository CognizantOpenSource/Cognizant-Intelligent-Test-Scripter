/*  1:   */ package com.cognizant.cognizantits.qcconnection.qcupdation;
/*  2:   */ 
/*  3:   */ import com4j.ComEnum;
/*  4:   */ 
/*  5:   */ public enum tagTDAPI_STEP_PARAM_TYPE
/*  6:   */   implements ComEnum
/*  7:   */ {
/*  8: 8 */   STEP_PARAM_PREDEF(
/*  9:   */   
/* 10:   */ 
/* 11:   */ 
/* 12:   */ 
/* 13:   */ 
/* 14:   */ 
/* 15:   */ 
/* 16:16 */     1),  STEP_PARAM_NULL(
/* 17:   */   
/* 18:   */ 
/* 19:   */ 
/* 20:   */ 
/* 21:   */ 
/* 22:   */ 
/* 23:   */ 
/* 24:25 */     2),  STEP_PARAM_VALUE(
/* 25:   */   
/* 26:   */ 
/* 27:   */ 
/* 28:   */ 
/* 29:   */ 
/* 30:   */ 
/* 31:   */ 
/* 32:34 */     3),  STEP_PARAM_BASE(
/* 33:   */   
/* 34:   */ 
/* 35:   */ 
/* 36:   */ 
/* 37:   */ 
/* 38:   */ 
/* 39:   */ 
/* 40:43 */     4);
/* 41:   */   
/* 42:   */   private final int value;
/* 43:   */   
/* 44:   */   private tagTDAPI_STEP_PARAM_TYPE(int value)
/* 45:   */   {
/* 46:47 */     this.value = value;
/* 47:   */   }
/* 48:   */   
/* 49:   */   public int comEnumValue()
/* 50:   */   {
/* 51:48 */     return this.value;
/* 52:   */   }
/* 53:   */ }


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.tagTDAPI_STEP_PARAM_TYPE
 * JD-Core Version:    0.7.0.1
 */