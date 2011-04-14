class InterestPointController < ApplicationController
   def list
    @interest_points = InterestPoint.find(:all)
   end

   def json 
    @interest_points = InterestPoint.find(:all)
   end

   def show
    @interest_point = InterestPoint.find(params[:id])
   end

   def new
    @interest_point = InterestPoint.new
   end

   def create
    @interest_point = InterestPoint.new(params[:interest_point])
    if @interest_point.save
        redirect_to :action => 'list'
    else
        render :action => 'new'
    end
   end

   def edit
    @interest_point = InterestPoint.find(params[:id])
   end


   def update
    @interest_point = InterestPoint.find(params[:id])
    if @interest_point.update_attributes(params[:interest_point])
        redirect_to :action => 'show', :id => @interest_point
    else
        render :action => 'edit'
    end
   end

   def delete
    InterestPoint.find(params[:id]).destroy
    redirect_to :action => 'list'
   end

end
