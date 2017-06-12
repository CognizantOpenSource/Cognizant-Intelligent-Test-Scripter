package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.DISPID;
import com4j.IID;
import com4j.VTID;

@IID("{B739B750-BFE1-43AF-8DD7-E8E8EFBBED7D}")
public abstract interface IDashboardFolderFactory
  extends IBaseFactoryEx
{
  @DISPID(9)
  @VTID(17)
  public abstract IList getChildPagesWithPrivateItems(IList paramIList);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IDashboardFolderFactory
 * JD-Core Version:    0.7.0.1
 */