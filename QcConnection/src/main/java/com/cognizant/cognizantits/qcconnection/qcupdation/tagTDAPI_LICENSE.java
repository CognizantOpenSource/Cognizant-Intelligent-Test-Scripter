/*  1:   */ package com.cognizant.cognizantits.qcconnection.qcupdation;
/*  2:   */ 
/*  3:   */ import com4j.ComEnum;
/*  4:   */ 
/*  5:   */ public enum tagTDAPI_LICENSE
/*  6:   */   implements ComEnum
/*  7:   */ {
/*  8: 8 */   LIC_DEFECT(
/*  9:   */   
/* 10:   */ 
/* 11:   */ 
/* 12:   */ 
/* 13:   */ 
/* 14:   */ 
/* 15:   */ 
/* 16:16 */     1),  LIC_TEST_LAB(
/* 17:   */   
/* 18:   */ 
/* 19:   */ 
/* 20:   */ 
/* 21:   */ 
/* 22:   */ 
/* 23:   */ 
/* 24:25 */     2),  LIC_REQUIREMENT(
/* 25:   */   
/* 26:   */ 
/* 27:   */ 
/* 28:   */ 
/* 29:   */ 
/* 30:   */ 
/* 31:   */ 
/* 32:34 */     3),  LIC_OTA_CLIENT(
/* 33:   */   
/* 34:   */ 
/* 35:   */ 
/* 36:   */ 
/* 37:   */ 
/* 38:   */ 
/* 39:   */ 
/* 40:43 */     4),  LIC_COLLABORATION(
/* 41:   */   
/* 42:   */ 
/* 43:   */ 
/* 44:   */ 
/* 45:   */ 
/* 46:   */ 
/* 47:   */ 
/* 48:52 */     6),  LIC_DASHBOARD(
/* 49:   */   
/* 50:   */ 
/* 51:   */ 
/* 52:   */ 
/* 53:   */ 
/* 54:   */ 
/* 55:   */ 
/* 56:61 */     12),  LIC_COMPONENTS(
/* 57:   */   
/* 58:   */ 
/* 59:   */ 
/* 60:   */ 
/* 61:   */ 
/* 62:   */ 
/* 63:   */ 
/* 64:70 */     13);
/* 65:   */   
/* 66:   */   private final int value;
/* 67:   */   
/* 68:   */   private tagTDAPI_LICENSE(int value)
/* 69:   */   {
/* 70:74 */     this.value = value;
/* 71:   */   }
/* 72:   */   
/* 73:   */   public int comEnumValue()
/* 74:   */   {
/* 75:75 */     return this.value;
/* 76:   */   }
/* 77:   */ }


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.tagTDAPI_LICENSE
 * JD-Core Version:    0.7.0.1
 */