package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.DISPID;
import com4j.IID;
import com4j.VTID;

@IID("{BE140C38-7D92-4C50-8C1C-A4E43C0FC329}")
public abstract interface IHierarchyFilter
  extends ITDFilter2
{
  @DISPID(16)
  @VTID(31)
  public abstract boolean keepHierarchical();
  
  @DISPID(16)
  @VTID(32)
  public abstract void keepHierarchical(boolean paramBoolean);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IHierarchyFilter
 * JD-Core Version:    0.7.0.1
 */