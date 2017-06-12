/*  1:   */ package com.cognizant.cognizantits.qcconnection.qcupdation;
/*  2:   */ 
/*  3:   */ import com4j.COM4J;
/*  4:   */ 
/*  5:   */ public abstract class ClassFactory
/*  6:   */ {
/*  7:   */   public static ITDConnection4 createTDConnection()
/*  8:   */   {
/*  9:16 */     return (ITDConnection4)COM4J.createInstance(ITDConnection4.class, "{C5CBD7B2-490C-45F5-8C40-B8C3D108E6D7}");
/* 10:   */   }
/* 11:   */   
/* 12:   */   public static IList createList()
/* 13:   */   {
/* 14:23 */     return (IList)COM4J.createInstance(IList.class, "{9007A7F1-AC71-4563-A943-CFF4051E7E3D}");
/* 15:   */   }
/* 16:   */   
/* 17:   */   public static IComFrec createComFrec()
/* 18:   */   {
/* 19:30 */     return (IComFrec)COM4J.createInstance(IComFrec.class, "{B2F590F7-BD30-45DD-90B7-F243D7E8B210}");
/* 20:   */   }
/* 21:   */   
/* 22:   */   public static IAmarillusHash createAmarillusHash()
/* 23:   */   {
/* 24:37 */     return (IAmarillusHash)COM4J.createInstance(IAmarillusHash.class, "{61C395DB-BDD5-4431-995D-E5F38E8FAC70}");
/* 25:   */   }
/* 26:   */   
/* 27:   */   public static IExport createExport()
/* 28:   */   {
/* 29:44 */     return (IExport)COM4J.createInstance(IExport.class, "{DCB4C421-E9F4-4A89-9190-B49411B17167}");
/* 30:   */   }
/* 31:   */   
/* 32:   */   public static IImport createImport()
/* 33:   */   {
/* 34:51 */     return (IImport)COM4J.createInstance(IImport.class, "{CD3E5686-4B11-462F-9619-D2FA447DCE96}");
/* 35:   */   }
/* 36:   */   
/* 37:   */   public static ITDUtils createTDUtils()
/* 38:   */   {
/* 39:58 */     return (ITDUtils)COM4J.createInstance(ITDUtils.class, "{977FEB6A-82DF-4F53-ADA2-F722F7E07D23}");
/* 40:   */   }
/* 41:   */   
/* 42:   */   public static IGroupingManager createGroupingManager()
/* 43:   */   {
/* 44:65 */     return (IGroupingManager)COM4J.createInstance(IGroupingManager.class, "{F801F7A2-04DF-4DD3-8A5E-C0CC66E0595E}");
/* 45:   */   }
/* 46:   */   
/* 47:   */   public static IGroupingItem createGroupingItem()
/* 48:   */   {
/* 49:72 */     return (IGroupingItem)COM4J.createInstance(IGroupingItem.class, "{904CED76-CF4A-4C85-BB23-2B4A9DCB1D6A}");
/* 50:   */   }
/* 51:   */   
/* 52:   */   public static IAuditRecordData createAuditRecordData()
/* 53:   */   {
/* 54:79 */     return (IAuditRecordData)COM4J.createInstance(IAuditRecordData.class, "{EB64EF73-64A5-48A1-8CE4-07C5487E32A6}");
/* 55:   */   }
/* 56:   */   
/* 57:   */   public static IReqType createReqType()
/* 58:   */   {
/* 59:86 */     return (IReqType)COM4J.createInstance(IReqType.class, "{1E2919FE-D94C-4E66-9FF6-9187A65A674E}");
/* 60:   */   }
/* 61:   */   
/* 62:   */   public static IWarningInfo createWarningInfo()
/* 63:   */   {
/* 64:93 */     return (IWarningInfo)COM4J.createInstance(IWarningInfo.class, "{0A3D3A7A-A798-4437-91B6-870D71DB0C10}");
/* 65:   */   }
/* 66:   */ }


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ClassFactory
 * JD-Core Version:    0.7.0.1
 */