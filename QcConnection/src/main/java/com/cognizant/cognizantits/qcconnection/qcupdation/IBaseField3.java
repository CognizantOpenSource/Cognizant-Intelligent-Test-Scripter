package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.DefaultValue;
import com4j.IID;
import com4j.Optional;
import com4j.VTID;

@IID("{E4DC1359-6281-42FA-B739-CFA8E4ECC23F}")
public abstract interface IBaseField3
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract void post(@Optional @DefaultValue("-1") boolean paramBoolean);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IBaseField3
 * JD-Core Version:    0.7.0.1
 */