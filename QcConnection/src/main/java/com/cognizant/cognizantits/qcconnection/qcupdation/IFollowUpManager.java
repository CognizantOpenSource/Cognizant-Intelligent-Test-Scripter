package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.IID;
import com4j.VTID;
import java.util.Date;

@IID("{6EE10992-2569-4838-86DA-DAE1E1240E79}")
public abstract interface IFollowUpManager
  extends Com4jObject
{
  @VTID(4)
  public abstract void setFollowUp(Date paramDate, String paramString);
  
  @VTID(5)
  public abstract void cancelFollowUp();
  
  @VTID(6)
  public abstract boolean hasFollowUp();
  
  @VTID(7)
  public abstract boolean isFollowUpOverdue();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IFollowUpManager
 * JD-Core Version:    0.7.0.1
 */