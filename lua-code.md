-- Create a function to calculate the values
local function calculate(width, height)
    -- Check if width and height are valid
    if width < 0 or height < 0 then
        print("Error: Width and height must be positive integers")
        return
    end

    -- Calculate cube blocks
    local cubeBlocks = width * width * height

    -- Calculate frames
    local framesTopBottom = 4 * (width - 1)
    local framesSide = 4 * (height - 2)
    local framesTotal = framesTopBottom * 2 + framesSide
    print("Frames: ".. framesTotal)

    -- Calculate vents
    local ventsTopBottom = (width - 2) * (width - 2)
    local ventsSide = ((height - 2) * (width - 2)) * 4
    local ventsTotal = (ventsTopBottom * 2) + ventsSide
    print("Vents: ".. ventsTotal)

    -- Calculate center cube
    local centerCube = cubeBlocks - (framesTotal + ventsTotal)

    -- Fill center cube with pattern provider and co-processors in a 2:1 ratio
    local patternProviderCount = math.floor(centerCube * 2 / 3)
    local coProcessorsCount = centerCube - patternProviderCount
    print("Pattern Provider (2:1): ".. patternProviderCount)
    print("Co-Processors (2:1): ".. coProcessorsCount)

    -- Fill center cube with pattern provider and co-processors in a 7:2 ratio
    local patternProviderCountTwo = math.floor(centerCube * 7 / 9)
    local coProcessorsCountTwo = centerCube - patternProviderCountTwo
    print("Pattern Provider (7:2): ".. patternProviderCountTwo)
    print("Co-Processors (7:2): ".. coProcessorsCountTwo)
end

-- Get input from user
print("Enter width:")
local width = tonumber(io.read())
print("Enter height:")
local height = tonumber(io.read())

-- Call the calculate function
calculate(width, height)
