package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.GUID;
import com4j.IID;
import com4j.VTID;

@IID("{1CF2B120-547D-101B-8E65-08002B2BD119}")
public abstract interface IErrorInfo
  extends Com4jObject
{
  @VTID(3)
  public abstract GUID getGUID();
  
  @VTID(4)
  public abstract String getSource();
  
  @VTID(5)
  public abstract String getDescription();
  
  @VTID(6)
  public abstract String getHelpFile();
  
  @VTID(7)
  public abstract int getHelpContext();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IErrorInfo
 * JD-Core Version:    0.7.0.1
 */