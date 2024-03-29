package org.beryl.schedule;

public abstract class AbstractSchedulableJob implements IJob {

	private volatile boolean cancel = false;
	
	
	public void cancel() {
		cancel = true;
	}

	public boolean isCanceled() {
		return cancel;
	}
	
	public boolean canWorkJob() {
		return ! isCanceled() && ! isAbandoned();
	}
	
	protected void checkRunnability() throws UnrunnableJobException {
		if(! canWorkJob()) {
			throw new UnrunnableJobException();
		}
	}
}
