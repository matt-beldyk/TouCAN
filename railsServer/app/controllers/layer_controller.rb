class LayerController < ApplicationController
   def list
    @layers = Layer.find(:all)


        respond_to do |format|
            format.html #index.html.erb
            format.xml {render :xml => @layers}
        end
    end

   def show
    @layer = Layer.find(params[:id])
   end

   def new
    @layer = Layer.new
   end

   def create
    @layer = Layer.new(params[:layer])
    if @layer.save
        redirect_to :action => 'list'
    else
        render :action => 'new'
    end
   end

   def edit
    @layer = Layer.find(params[:id])
   end


   def update
    @layer = Layer.find(params[:id])
    if @layer.update_attributes(params[:layer])
        redirect_to :action => 'show', :id => @layer
    else
        render :action => 'edit'
    end
   end

   def delete
    Layer.find(params[:id]).destroy
    redirect_to :action => 'list'
   end

end
