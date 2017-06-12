package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.DISPID;
import com4j.IID;
import com4j.VTID;

@IID("{39B5BBE5-9E03-40F3-82DF-881A0867CDF8}")
public abstract interface ITSScheduler2
  extends ITSScheduler
{
  @DISPID(11)
  @VTID(23)
  public abstract boolean changeDetectEnabled();
  
  @DISPID(11)
  @VTID(24)
  public abstract void changeDetectEnabled(boolean paramBoolean);
  
  @DISPID(12)
  @VTID(25)
  public abstract boolean skipNonChangeDetectableComponentsEnabled();
  
  @DISPID(12)
  @VTID(26)
  public abstract void skipNonChangeDetectableComponentsEnabled(boolean paramBoolean);
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.ITSScheduler2
 * JD-Core Version:    0.7.0.1
 */