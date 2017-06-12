package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.VTID;

@IID("{16201C2D-9330-4598-AC93-4332F63D7294}")
public abstract interface ILibraryInfo
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract String domain();
  
  @DISPID(2)
  @VTID(8)
  public abstract String project();
  
  @DISPID(3)
  @VTID(9)
  public abstract int libraryID();
  
  @DISPID(4)
  @VTID(10)
  public abstract String libraryName();
  
  @DISPID(5)
  @VTID(11)
  public abstract String lastSyncDate();
  
  @DISPID(6)
  @VTID(12)
  public abstract String importDate();
  
  @DISPID(7)
  @VTID(13)
  public abstract String importingUser();
  
  @DISPID(8)
  @VTID(14)
  public abstract int baselineId();
  
  @DISPID(9)
  @VTID(15)
  public abstract String baselineName();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ILibraryInfo
 * JD-Core Version:    0.7.0.1
 */