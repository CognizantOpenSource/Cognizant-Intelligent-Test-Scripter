package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.Holder;
import com4j.IID;
import com4j.VTID;

@IID("{2C8D6469-AE61-4F01-801E-6B2087216786}")
public abstract interface IProductInfo
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract int qcVersion(Holder<Integer> paramHolder1, Holder<Integer> paramHolder2);
  
  @DISPID(2)
  @VTID(8)
  public abstract int bptVersion();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IProductInfo
 * JD-Core Version:    0.7.0.1
 */