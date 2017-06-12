package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.DefaultValue;
import com4j.IID;
import com4j.Optional;
import com4j.VTID;

@IID("{1E41E461-210B-43DC-B9DE-6E1CF81C5B52}")
public abstract interface ISupportHierarchicalFilter
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract IList getFilteredChildren(int paramInt, @Optional @DefaultValue("0") ITDFilter paramITDFilter);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ISupportHierarchicalFilter
 * JD-Core Version:    0.7.0.1
 */