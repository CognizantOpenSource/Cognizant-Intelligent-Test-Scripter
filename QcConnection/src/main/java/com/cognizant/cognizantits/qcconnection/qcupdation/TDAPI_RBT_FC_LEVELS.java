/*  1:   */ package com.cognizant.cognizantits.qcconnection.qcupdation;
/*  2:   */ 
/*  3:   */ import com4j.ComEnum;
/*  4:   */ 
/*  5:   */ public enum TDAPI_RBT_FC_LEVELS
/*  6:   */   implements ComEnum
/*  7:   */ {
/*  8:11 */   RBT_FC_LEVEL_1(
/*  9:   */   
/* 10:   */ 
/* 11:   */ 
/* 12:   */ 
/* 13:   */ 
/* 14:   */ 
/* 15:   */ 
/* 16:19 */     1),  RBT_FC_LEVEL_2(
/* 17:   */   
/* 18:   */ 
/* 19:   */ 
/* 20:   */ 
/* 21:   */ 
/* 22:   */ 
/* 23:   */ 
/* 24:28 */     2),  RBT_FC_LEVEL_3(
/* 25:   */   
/* 26:   */ 
/* 27:   */ 
/* 28:   */ 
/* 29:   */ 
/* 30:   */ 
/* 31:   */ 
/* 32:37 */     3);
/* 33:   */   
/* 34:   */   private final int value;
/* 35:   */   
/* 36:   */   private TDAPI_RBT_FC_LEVELS(int value)
/* 37:   */   {
/* 38:41 */     this.value = value;
/* 39:   */   }
/* 40:   */   
/* 41:   */   public int comEnumValue()
/* 42:   */   {
/* 43:42 */     return this.value;
/* 44:   */   }
/* 45:   */ }


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.TDAPI_RBT_FC_LEVELS
 * JD-Core Version:    0.7.0.1
 */