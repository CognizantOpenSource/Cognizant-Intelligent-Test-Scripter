/*  1:   */ package com.cognizant.cognizantits.qcconnection.qcupdation;
/*  2:   */ 
/*  3:   */ import com4j.ComEnum;
/*  4:   */ 
/*  5:   */ public enum tagTDAPI_GRAPH_TYPE
/*  6:   */   implements ComEnum
/*  7:   */ {
/*  8: 8 */   GRAPH_SUMMARY(
/*  9:   */   
/* 10:   */ 
/* 11:   */ 
/* 12:   */ 
/* 13:   */ 
/* 14:   */ 
/* 15:   */ 
/* 16:16 */     0),  GRAPH_AGE(
/* 17:   */   
/* 18:   */ 
/* 19:   */ 
/* 20:   */ 
/* 21:   */ 
/* 22:   */ 
/* 23:   */ 
/* 24:25 */     1),  GRAPH_PROGRESS(
/* 25:   */   
/* 26:   */ 
/* 27:   */ 
/* 28:   */ 
/* 29:   */ 
/* 30:   */ 
/* 31:   */ 
/* 32:34 */     2),  GRAPH_TREND(
/* 33:   */   
/* 34:   */ 
/* 35:   */ 
/* 36:   */ 
/* 37:   */ 
/* 38:   */ 
/* 39:   */ 
/* 40:43 */     3),  GRAPH_COVERAGE(
/* 41:   */   
/* 42:   */ 
/* 43:   */ 
/* 44:   */ 
/* 45:   */ 
/* 46:   */ 
/* 47:   */ 
/* 48:52 */     5);
/* 49:   */   
/* 50:   */   private final int value;
/* 51:   */   
/* 52:   */   private tagTDAPI_GRAPH_TYPE(int value)
/* 53:   */   {
/* 54:56 */     this.value = value;
/* 55:   */   }
/* 56:   */   
/* 57:   */   public int comEnumValue()
/* 58:   */   {
/* 59:57 */     return this.value;
/* 60:   */   }
/* 61:   */ }


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.tagTDAPI_GRAPH_TYPE
 * JD-Core Version:    0.7.0.1
 */