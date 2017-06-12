package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.VTID;

@IID("{5073A186-2A46-4C93-A3F5-F8C0AA66694F}")
public abstract interface IAmarillusHash
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract String generateHash(String paramString);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IAmarillusHash
 * JD-Core Version:    0.7.0.1
 */