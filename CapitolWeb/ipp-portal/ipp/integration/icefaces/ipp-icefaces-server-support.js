function performIppAiClosePanelCommand()
{
  //alert("Executing performIppAiClosePanelCommand()");

  try
  {
	  var theForm = document.forms['ippIcefacesPanelForm'];
	  if ( !theForm) {
		  //alert('Falling back to first defined form: ' + document.forms[0]);
		  theForm = document.forms[0];
	  }
	  
	  iceSubmit(theForm, null, null);
	  return;
  }
  catch (x) {
	  alert('Failed submitting form: ' + x);
  }
}

function confirmIppAiClosePanelCommand(commandId)
{
  //alert("Executing confirmIppAiClosePanelCommand(" + commandId + ")");
  
  var mainIppFrame = top;

  if (mainIppFrame)
  {
    if (mainIppFrame.InfinityBpm)
    {
      try
      {
        //disposeOnViewRemoval('ipp-embedded-activity-panel');  
    	
        if ('complete' === commandId) {
        	mainIppFrame.InfinityBpm.ProcessPortal.completeActivity();
        } else if ('suspendAndSave' === commandId) {
        	mainIppFrame.InfinityBpm.ProcessPortal.suspendActivity(true);
        } else if ('suspend' === commandId) {
        	mainIppFrame.InfinityBpm.ProcessPortal.suspendActivity(false);
        } else if ('abort' === commandId) {
        	mainIppFrame.InfinityBpm.ProcessPortal.abortActivity();
        }
      }
      catch (x)
      {
        // probably forbidden to access location, assuming other page
        alert(x);
      }
    }
    else
    {
      alert('Did not find InfinityBpm module in main process portal frame.');
    }
  }
}
