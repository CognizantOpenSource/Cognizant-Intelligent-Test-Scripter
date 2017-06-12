/*  1:   */ package com.cognizant.cognizantits.qcconnection.qcupdation;
/*  2:   */ 
/*  3:   */ import com4j.ComEnum;
/*  4:   */ 
/*  5:   */ public enum tagTDAPI_EXECUTIONEVENTACTIONTARGET
/*  6:   */   implements ComEnum
/*  7:   */ {
/*  8: 8 */   EXECEVENTACTIONTARGET_TEST(
/*  9:   */   
/* 10:   */ 
/* 11:   */ 
/* 12:   */ 
/* 13:   */ 
/* 14:   */ 
/* 15:   */ 
/* 16:16 */     1),  EXECEVENTACTIONTARGET_TESTSET(
/* 17:   */   
/* 18:   */ 
/* 19:   */ 
/* 20:   */ 
/* 21:   */ 
/* 22:   */ 
/* 23:   */ 
/* 24:25 */     2);
/* 25:   */   
/* 26:   */   private final int value;
/* 27:   */   
/* 28:   */   private tagTDAPI_EXECUTIONEVENTACTIONTARGET(int value)
/* 29:   */   {
/* 30:29 */     this.value = value;
/* 31:   */   }
/* 32:   */   
/* 33:   */   public int comEnumValue()
/* 34:   */   {
/* 35:30 */     return this.value;
/* 36:   */   }
/* 37:   */ }


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.tagTDAPI_EXECUTIONEVENTACTIONTARGET
 * JD-Core Version:    0.7.0.1
 */