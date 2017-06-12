package com.cognizant.cognizantits.qcconnection.qcupdation;

import com4j.Com4jObject;
import com4j.DISPID;
import com4j.IID;
import com4j.NativeType;
import com4j.ReturnValue;
import com4j.VTID;

@IID("{CCD9F62A-3899-4233-9C2C-A25BFF1AF041}")
public abstract interface IReqSummaryStatus
  extends Com4jObject
{
  @DISPID(1)
  @VTID(7)
  public abstract IList possibleStatuses();
  
  @VTID(7)
  @ReturnValue(type=NativeType.VARIANT, defaultPropertyThrough={IList.class})
  public abstract Object possibleStatuses(int paramInt);
  
  @DISPID(2)
  @VTID(8)
  public abstract int summaryStatus(String paramString);
  
  @DISPID(3)
  @VTID(9)
  public abstract int totalSummaryNodes();
  
  @DISPID(4)
  @VTID(10)
  public abstract int reqID();
}


/* Location:           D:\Prabu\jars\QC.jar
 * Qualified Name:     qcupdation.IReqSummaryStatus
 * JD-Core Version:    0.7.0.1
 */