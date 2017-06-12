package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.DefaultValue;
import com4j.IID;
import com4j.MarshalAs;
import com4j.NativeType;
import com4j.Optional;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{21EABA3E-8FF5-46A1-B4C2-14998C9DA677}")
public abstract interface ITDConnection4
  extends ITDConnection3
{
  @DISPID(107)
  @VTID(116)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject getFavoriteFolderFactory(boolean paramBoolean, String paramString);
  
  @DISPID(108)
  @VTID(117)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject getFavoriteFactory(boolean paramBoolean, String paramString);
  
  @DISPID(109)
  @VTID(118)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject getRootsFavoriteFolderFactory(boolean paramBoolean, String paramString);
  
  @DISPID(110)
  @VTID(119)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject getRootsFavoriteFactory(boolean paramBoolean, String paramString);
  
  @DISPID(111)
  @VTID(120)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject libraryFolderFactory();
  
  @DISPID(112)
  @VTID(121)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject libraryFactory();
  
  @DISPID(113)
  @VTID(122)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject baselineFactory();
  
  @DISPID(114)
  @VTID(123)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject policyStatus();
  
  @DISPID(115)
  @VTID(124)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject templateManager();
  
  @DISPID(118)
  @VTID(125)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject analysisItemFolderFactory();
  
  @DISPID(119)
  @VTID(126)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject analysisItemFactory();
  
  @DISPID(120)
  @VTID(127)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject rootsAnalysisItemFolderFactory();
  
  @DISPID(121)
  @VTID(128)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject rootsAnalysisItemFactory();
  
  @DISPID(122)
  @VTID(129)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject qcResourceFactory();
  
  @DISPID(123)
  @VTID(130)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject qcResourceFolderFactory();
  
  @DISPID(124)
  @VTID(131)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject dashboardFolderFactory();
  
  @DISPID(125)
  @VTID(132)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject dashboardPageFactory();
  
  @DISPID(126)
  @VTID(133)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject rootsDashboardFolderFactory();
  
  @DISPID(127)
  @VTID(134)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject rootsDashboardPageFactory();
  
  @DISPID(128)
  @VTID(135)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject comparisonFactory();
  
  @DISPID(129)
  @VTID(136)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject comparisonNodeFactory();
  
  @DISPID(130)
  @VTID(137)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject assetRelationFactory();
  
  @DISPID(131)
  @VTID(138)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject userAssetFactory();
  
  @DISPID(132)
  @VTID(139)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject assetRepositoryItemFactory();
  
  @DISPID(133)
  @VTID(140)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject crossProjectAPI();
  
  @DISPID(134)
  @VTID(141)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject taskFactory();
  
  @DISPID(135)
  @VTID(142)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject taskLogFactory();
  
  @DISPID(136)
  @VTID(143)
  public abstract void sendFramedMail(String paramString1, @Optional @DefaultValue("") String paramString2, @Optional @DefaultValue("") String paramString3, @Optional @DefaultValue("") String paramString4, @Optional @MarshalAs(NativeType.VARIANT) Object paramObject);
  
  @DISPID(137)
  @VTID(144)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject licenseManager();
  
  @DISPID(138)
  @VTID(145)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject dashboardPageItemFactory();
  
  @DISPID(139)
  @VTID(146)
  public abstract IList getAllVisibleProjectDescriptors();
  
  @VTID(146)
  @ReturnValue(type=NativeType.VARIANT, defaultPropertyThrough={IList.class})
  public abstract Object getAllVisibleProjectDescriptors(int paramInt);
  
  @DISPID(140)
  @VTID(147)
  public abstract void refreshConnectionState();
  
  @DISPID(141)
  @VTID(148)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject excelReportManager();
  
  @DISPID(142)
  @VTID(149)
  public abstract void clientVersion(String paramString1, @Optional @DefaultValue("") String paramString2);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ITDConnection4
 * JD-Core Version:    0.7.0.1
 */