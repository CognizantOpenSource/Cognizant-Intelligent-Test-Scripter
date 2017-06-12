package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.Holder;
import com4j.IID;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{3A6DFEA9-5E15-4E8F-B480-2B025730F7BD}")
public abstract interface IImport
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  @ReturnValue(index=0)
  public abstract String getColumnNames(String paramString);
  
  @DISPID(2)
  @VTID(8)
  public abstract void importData(String paramString, Holder<String> paramHolder);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IImport
 * JD-Core Version:    0.7.0.1
 */