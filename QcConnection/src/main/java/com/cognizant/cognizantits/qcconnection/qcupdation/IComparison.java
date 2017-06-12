package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.DISPID;
import com4j.Holder;
import com4j.IID;
import com4j.VTID;
import java.util.Date;

@IID("{CDFF6E1D-5B22-44E4-8877-510D4FB0A1BD}")
public abstract interface IComparison
  extends IBaseFieldEx
{
  @DISPID(14)
  @VTID(23)
  public abstract String name();
  
  @DISPID(14)
  @VTID(24)
  public abstract void name(String paramString);
  
  @DISPID(15)
  @VTID(25)
  public abstract String creatorUser();
  
  @DISPID(16)
  @VTID(26)
  public abstract Date creationDate();
  
  @DISPID(17)
  @VTID(27)
  public abstract ILibraryInfo leftEntityId();
  
  @DISPID(18)
  @VTID(28)
  public abstract ILibraryInfo rightEntityId();
  
  @DISPID(19)
  @VTID(29)
  public abstract IComparisonNode leftRoot();
  
  @DISPID(20)
  @VTID(30)
  public abstract IComparisonNode rightRoot();
  
  @DISPID(21)
  @VTID(31)
  public abstract int state();
  
  @DISPID(22)
  @VTID(32)
  public abstract void compareLibraries(ILibraryInfo paramILibraryInfo1, int paramInt1, ILibraryInfo paramILibraryInfo2, int paramInt2, IList paramIList, Holder<IComparisonNode> paramHolder1, Holder<IComparisonNode> paramHolder2);
  
  @DISPID(23)
  @VTID(33)
  public abstract void compareBaselines(int paramInt1, int paramInt2, IList paramIList, Holder<IComparisonNode> paramHolder1, Holder<IComparisonNode> paramHolder2);
  
  @DISPID(24)
  @VTID(34)
  public abstract IComparisonSettings getComparisonSettings(String paramString, IList paramIList, boolean paramBoolean1, boolean paramBoolean2);
  
  @DISPID(25)
  @VTID(35)
  public abstract IList compareEntities(ILibraryInfo paramILibraryInfo1, int paramInt1, ILibraryInfo paramILibraryInfo2, int paramInt2, IList paramIList, int paramInt3, int paramInt4, String paramString);
  
  @DISPID(26)
  @VTID(36)
  public abstract IList compareVersionedEntities(int paramInt1, int paramInt2, int paramInt3, IList paramIList, String paramString);
  
  @DISPID(27)
  @VTID(37)
  public abstract int getComparisonStatistics(boolean paramBoolean, String paramString, int paramInt);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IComparison
 * JD-Core Version:    0.7.0.1
 */