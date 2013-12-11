function emitIppAiClosePanelCommand()
{
  //alert("Executing emitIppAiClosePanelCommand()");

  var workareaFrame = parent['ipp-embedded-activity-panel'];

  if (workareaFrame)
  {
    //alert("Found embedded AI panel iFrame: " + workareaFrame);
	  
    if (workareaFrame.performIppAiClosePanelCommand)
    {
      try
      {
      	workareaFrame.performIppAiClosePanelCommand();
      }
      catch (x)
      {
        // probably forbidden to access location, assuming other page
        alert(x);
      }
    }
    else
    {
      alert('Did not find performIppAiClosePanelCommand method in embedded AI panel iFrame');
    }
  }
}
