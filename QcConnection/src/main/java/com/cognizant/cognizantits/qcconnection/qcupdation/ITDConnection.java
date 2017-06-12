package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.DefaultValue;
import com4j.Holder;
import com4j.IID;
import com4j.MarshalAs;
import com4j.NativeType;
import com4j.Optional;
import com4j.ReturnValue;
import com4j.VTID;
import java.util.Date;

@IID("{DB67E08D-7FA7-4DAC-87BB-2A55CBFFE008}")
public abstract interface ITDConnection
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract boolean connected();
  
  @DISPID(2)
  @VTID(8)
  public abstract boolean projectConnected();
  
  @DISPID(3)
  @VTID(9)
  public abstract String serverName();
  
  @DISPID(4)
  @VTID(10)
  public abstract String projectName();
  
  @DISPID(5)
  @VTID(11)
  public abstract String testRepository();
  
  @DISPID(6)
  @VTID(12)
  public abstract String userName();
  
  @DISPID(7)
  @VTID(13)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject testFactory();
  
  @DISPID(8)
  @VTID(14)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject bugFactory();
  
  @DISPID(9)
  @VTID(15)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject testSetFactory();
  
  @DISPID(10)
  @VTID(16)
  public abstract IList userGroupsList();
  
  @VTID(16)
  @ReturnValue(type=NativeType.VARIANT, defaultPropertyThrough={IList.class})
  public abstract Object userGroupsList(int paramInt);
  
  @DISPID(11)
  @VTID(17)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject hostFactory();
  
  @DISPID(12)
  @VTID(18)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject vcs();
  
  @DISPID(13)
  @VTID(19)
  public abstract void initConnection(String paramString1, @Optional @DefaultValue("") String paramString2, @Optional @DefaultValue("") String paramString3);
  
  @DISPID(14)
  @VTID(20)
  public abstract void releaseConnection();
  
  @DISPID(15)
  @VTID(21)
  public abstract void connectProject(String paramString1, String paramString2, @Optional @DefaultValue("") String paramString3);
  
  @DISPID(16)
  @VTID(22)
  public abstract void disconnectProject();
  
  @DISPID(17)
  @VTID(23)
  public abstract IList projectsList();
  
  @VTID(23)
  @ReturnValue(type=NativeType.VARIANT, defaultPropertyThrough={IList.class})
  public abstract Object projectsList(int paramInt);
  
  @DISPID(18)
  @VTID(24)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject command();
  
  @DISPID(19)
  @VTID(25)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject treeManager();
  
  @DISPID(20)
  @VTID(26)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject reqFactory();
  
  @DISPID(21)
  @VTID(27)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject actionPermission();
  
  @DISPID(22)
  @VTID(28)
  public abstract void getLicense(int paramInt);
  
  @DISPID(23)
  @VTID(29)
  public abstract void sendMail(String paramString1, @Optional @DefaultValue("") String paramString2, @Optional @DefaultValue("") String paramString3, @Optional @DefaultValue("") String paramString4, @Optional @MarshalAs(NativeType.VARIANT) Object paramObject, @Optional @DefaultValue("") String paramString5);
  
  @DISPID(24)
  @VTID(30)
  public abstract String dbType();
  
  @DISPID(25)
  @VTID(31)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject dbManager();
  
  @DISPID(26)
  @VTID(32)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject customization();
  
  @DISPID(27)
  @VTID(33)
  public abstract IList fields(String paramString);
  
  @DISPID(28)
  @VTID(34)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject commonSettings();
  
  @DISPID(29)
  @VTID(35)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject userSettings();
  
  @DISPID(30)
  @VTID(36)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject hostGroupFactory();
  
  @DISPID(31)
  @VTID(37)
  public abstract void changePassword(String paramString1, String paramString2);
  
  @DISPID(32)
  @VTID(38)
  public abstract IList usersList();
  
  @VTID(38)
  @ReturnValue(type=NativeType.VARIANT, defaultPropertyThrough={IList.class})
  public abstract Object usersList(int paramInt);
  
  @DISPID(33)
  @VTID(39)
  public abstract String password();
  
  @DISPID(34)
  @VTID(40)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject extendedStorage();
  
  @DISPID(35)
  @VTID(41)
  public abstract String directoryPath(int paramInt);
  
  @DISPID(36)
  @VTID(42)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject changeFactory();
  
  @DISPID(37)
  @VTID(43)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject mailConditions();
  
  @DISPID(38)
  @VTID(44)
  public abstract Date serverTime();
  
  @DISPID(39)
  @VTID(45)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject tdSettings();
  
  @DISPID(40)
  @VTID(46)
  public abstract void purgeRuns(String paramString, int paramInt1, @MarshalAs(NativeType.VARIANT) Object paramObject, int paramInt2, boolean paramBoolean);
  
  @DISPID(41)
  @VTID(47)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject projectProperties();
  
  @DISPID(42)
  @VTID(48)
  public abstract void getLicenseStatus(int paramInt, Holder<Integer> paramHolder1, Holder<Integer> paramHolder2);
  
  @DISPID(43)
  @VTID(49)
  public abstract String domainName();
  
  @DISPID(44)
  @VTID(50)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject textParam();
  
  @DISPID(45)
  @VTID(51)
  public abstract String tdParams(String paramString);
  
  @DISPID(46)
  @VTID(52)
  public abstract boolean usingProgress();
  
  @DISPID(46)
  @VTID(53)
  public abstract void usingProgress(boolean paramBoolean);
  
  @DISPID(47)
  @VTID(54)
  public abstract String checkoutRepository();
  
  @DISPID(48)
  @VTID(55)
  public abstract String viewsRepository();
  
  @DISPID(49)
  @VTID(56)
  public abstract String vcsDbRepository();
  
  @DISPID(50)
  @VTID(57)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject runFactory();
  
  @DISPID(51)
  @VTID(58)
  public abstract boolean moduleVisible(int paramInt);
  
  @DISPID(52)
  @VTID(59)
  public abstract void initConnectionEx(String paramString);
  
  @DISPID(53)
  @VTID(60)
  public abstract IList projectsListEx(String paramString);
  
  @DISPID(54)
  @VTID(61)
  public abstract void connectProjectEx(String paramString1, String paramString2, String paramString3, @Optional @DefaultValue("") String paramString4);
  
  @DISPID(55)
  @VTID(62)
  public abstract IList domainsList();
  
  @VTID(62)
  @ReturnValue(type=NativeType.VARIANT, defaultPropertyThrough={IList.class})
  public abstract Object domainsList(int paramInt);
  
  @DISPID(56)
  @VTID(63)
  public abstract void connectToVCSAs(String paramString1, String paramString2, String paramString3);
  
  @DISPID(57)
  @VTID(64)
  public abstract void getLicenses(int paramInt, Holder<String> paramHolder);
  
  @DISPID(58)
  @VTID(65)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject analysis();
  
  @DISPID(59)
  @VTID(66)
  public abstract String vmRepository();
  
  @DISPID(60)
  @VTID(67)
  public abstract String dbName();
  
  @DISPID(61)
  @VTID(68)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject rules();
  
  @DISPID(62)
  @VTID(69)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject testSetTreeManager();
  
  @DISPID(63)
  @VTID(70)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject alertManager();
  
  @DISPID(64)
  @VTID(71)
  public abstract boolean allowReconnect();
  
  @DISPID(64)
  @VTID(72)
  public abstract void allowReconnect(boolean paramBoolean);
  
  @DISPID(65)
  @VTID(73)
  public abstract void synchronizeFollowUps(String paramString);
  
  @DISPID(66)
  @VTID(74)
  public abstract boolean keepConnection();
  
  @DISPID(66)
  @VTID(75)
  public abstract void keepConnection(boolean paramBoolean);
  
  @DISPID(67)
  @VTID(76)
  public abstract boolean ignoreHtmlFormat();
  
  @DISPID(67)
  @VTID(77)
  public abstract void ignoreHtmlFormat(boolean paramBoolean);
  
  @DISPID(68)
  @VTID(78)
  public abstract String reportRole();
  
  @DISPID(69)
  @VTID(79)
  public abstract void clientType(String paramString1, @Optional @DefaultValue("") String paramString2);
  
  @DISPID(70)
  @VTID(80)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject componentFactory();
  
  @DISPID(71)
  @VTID(81)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject componentFolderFactory();
  
  @DISPID(72)
  @VTID(82)
  public abstract void getTDVersion(Holder<String> paramHolder1, Holder<String> paramHolder2);
  
  @DISPID(73)
  @VTID(83)
  public abstract String serverURL();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ITDConnection
 * JD-Core Version:    0.7.0.1
 */