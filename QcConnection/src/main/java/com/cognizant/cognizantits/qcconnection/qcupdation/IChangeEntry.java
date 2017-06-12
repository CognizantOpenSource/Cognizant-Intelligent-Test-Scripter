package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.DISPID;
import com4j.IID;
import com4j.VTID;
import java.util.Date;

@IID("{0977F04D-0A7C-403D-A07B-1C2780362C46}")
public abstract interface IChangeEntry
  extends IBaseFieldEx
{
  @DISPID(14)
  @VTID(23)
  public abstract String fileName();
  
  @DISPID(15)
  @VTID(24)
  public abstract String filePath();
  
  @DISPID(16)
  @VTID(25)
  public abstract String startVersion();
  
  @DISPID(17)
  @VTID(26)
  public abstract String workingVersion();
  
  @DISPID(17)
  @VTID(27)
  public abstract void workingVersion(String paramString);
  
  @DISPID(18)
  @VTID(28)
  public abstract String endVersion();
  
  @DISPID(18)
  @VTID(29)
  public abstract void endVersion(String paramString);
  
  @DISPID(19)
  @VTID(30)
  public abstract String createdBy();
  
  @DISPID(20)
  @VTID(31)
  public abstract Date creationDate();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IChangeEntry
 * JD-Core Version:    0.7.0.1
 */