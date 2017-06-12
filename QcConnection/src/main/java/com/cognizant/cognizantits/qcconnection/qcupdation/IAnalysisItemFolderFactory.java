package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{A7ECE1B7-1BC6-4E79-9494-6DA9BED9020F}")
public abstract interface IAnalysisItemFolderFactory
  extends IBaseFactoryEx
{
  @DISPID(9)
  @VTID(17)
  public abstract IList getChildItemsIncludedInPages(IList paramIList, boolean paramBoolean);
  
  @DISPID(10)
  @VTID(18)
  @ReturnValue(type=NativeType.Dispatch)
  public abstract Com4jObject getTreeRoot(boolean paramBoolean);
  
  @DISPID(11)
  @VTID(19)
  public abstract int getTreeRootID(boolean paramBoolean);
  
  @DISPID(12)
  @VTID(20)
  public abstract boolean isTreeRootEditable(boolean paramBoolean);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IAnalysisItemFolderFactory
 * JD-Core Version:    0.7.0.1
 */